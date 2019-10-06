package org.hakeem.unidata.repositories;

import com.google.common.base.CaseFormat;
import org.hakeem.unidata.entities.BaseModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.UniqueConstraint;
import javax.persistence.criteria.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;


/**
 * @author Kristijan Georgiev
 * @author abiel
 *
 * @param <T>   the class of the entity
 * @param <ID>   the ID class of the entity
 */
public class UnidataCrudRepositoryImpl<T extends BaseModel, ID extends UUID> extends SimpleJpaRepository<T, ID> implements UnidataCrudRepository<T,ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private final Class<T> domainClass;
    private static final String DELETED_FIELD = "deletedOn";

    public UnidataCrudRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.domainClass = domainClass;
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, em);
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        return null;
    }

    @Override
    public T findOne(ID id) {
        return super.findOne(
                Specifications.where(new ByIdSpecification<T, ID>(entityInformation, id)).
                        and(notDeleted())).orElse(null);
    }

    @Override
    public List<T> findDeleted() {
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return super.count(Specifications.where(new ByIdSpecification<>(entityInformation, id)).
                and(notDeleted())) > 0;
    }

    @Override
    public long count() {
        return super.count(notDeleted());
    }

    @Override
    public void delete(ID id) {
         Assert.notNull(id, "id should not be null");
         softDelete(id, LocalDateTime.now());
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
          Assert.notNull(entities, "The given Iterable of entities not be null!");
          entities.forEach(this::delete);
    }

    @Override
    @Transactional
    public  void delete(@NotNull T entity){
        Assert.notNull(entity, "The entity must not be null!");
        softDelete(entity, LocalDateTime.now());
    }

    @Transactional
    public void softDelete(Iterable<? extends T> entities) {
        Assert.notNull(entities, "The given Iterable of entities not be null!");
        for (T entity : entities)
            delete(entity);
    }

    @Transactional
    private void softDelete(ID id, LocalDateTime localDateTime) {
        Assert.notNull(id, "The given id must not be null!");
        T entity = findOne(id);

        if (entity == null)
            throw new EmptyResultDataAccessException(
                    String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1);

        softDelete(entity, localDateTime);
    }



    private void softDelete(T entity, LocalDateTime localDateTime) {
        Assert.notNull(entity, "The entity must not be null!");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<T> update = cb.createCriteriaUpdate(domainClass);

        Root<T> root = update.from(domainClass);
        update.set(DELETED_FIELD, localDateTime);

        final List<Predicate> predicates = new ArrayList<Predicate>();

        if (entityInformation.hasCompositeId()) {
            for (String s : entityInformation.getIdAttributeNames())
                predicates.add(cb.equal(root.<ID>get(s),
                        entityInformation.getCompositeIdAttributeValue(requireNonNull(entityInformation.getId(entity),"Id is null"), s)));
            update.where(cb.and(predicates.toArray(new Predicate[0])));
        } else
            update.where(cb.equal(root.<ID>get(requireNonNull(entityInformation.getIdAttribute(), "IdAttribute is null").getName()),
                    entityInformation.getId(entity)));

        em.createQuery(update).executeUpdate();
    }


    @NotNull
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public <S extends T> S save(@NotNull S entity) {
        Set<ConstraintViolation<S>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator()
                .validate(entity);

        if (constraintViolations.size() > 0)
            throw new ConstraintViolationException(constraintViolations.toString(), constraintViolations);

        Class<?> entityClass = entity.getClass();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> root = criteriaQuery.from(entityClass);

        List<Predicate> predicates = new ArrayList<>();

        if (entityInformation.hasCompositeId()) {
            for (String s : entityInformation.getIdAttributeNames())
                predicates.add(criteriaBuilder.equal(root.<ID>get(s),
                        entityInformation.getCompositeIdAttributeValue(requireNonNull(entityInformation.getId(entity),"entity Id is null"), s)));

            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(DELETED_FIELD), LocalDateTime.now()));

            criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            TypedQuery<Object> typedQuery = em.createQuery(criteriaQuery);
            List<Object> resultSet = typedQuery.getResultList();

            if (resultSet.size() > 0) {
                S result = (S) resultSet.get(0);
                BeanUtils.copyProperties(entity, result, getNullPropertyNames(entity));
                return super.save(result);
            }
        }

        if (entity.getClass().isAnnotationPresent(Table.class)) {
            Annotation a = entity.getClass().getAnnotation(Table.class);

            try {
                UniqueConstraint[] uniqueConstraints = (UniqueConstraint[]) a.annotationType()
                        .getMethod("uniqueConstraints").invoke(a);

                if (uniqueConstraints != null) {
                    for (UniqueConstraint uniqueConstraint : uniqueConstraints) {
                        Map<String, Object> data = new HashMap<>();

                        for (String name : uniqueConstraint.columnNames()) {
                            if (name.endsWith("_id"))
                                name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,
                                        name.substring(0, name.length() - 3));

                            PropertyDescriptor pd = new PropertyDescriptor(name, entityClass);
                            Object value = pd.getReadMethod().invoke(entity);

                            if (value == null) {
                                data.clear();
                                break;
                            }

                            data.put(name, value);
                        }

                        if (!data.isEmpty())
                            for (Map.Entry<String, Object> entry : data.entrySet())
                                predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
                    }

                    if (predicates.isEmpty())
                        return super.save(entity);

                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(DELETED_FIELD), LocalDateTime.now()));

                    criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
                    TypedQuery<Object> typedQuery = em.createQuery(criteriaQuery);
                    List<Object> resultSet = typedQuery.getResultList();

                    if (resultSet.size() > 0) {
                        S result = (S) resultSet.get(0);

                        BeanUtils.copyProperties(entity,
                                result, Stream
                                        .concat(Arrays.stream(getNullPropertyNames(entity)),
                                                Arrays.stream(
                                                        new String[] { requireNonNull(entityInformation.getIdAttribute(), "IdAttribute is null").getName() }))
                                        .toArray(String[]::new));

                        return super.save(result);
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException | IntrospectionException e) {
                e.printStackTrace();
            }
        }
        return super.save(entity);
    }



    @NotNull
    @Override
    @Transactional
    public <S extends T> S saveAndFlush(@NotNull S entity) {
        S result = this.save(entity);
        flush();
        return result;
    }

    @Override
    @Transactional
    public <S extends T> List<S> save(Iterable<S> entities) {

        List<S> result = new ArrayList<>();

        if (entities == null) {
            return result;
        }

        for (S entity : entities) {
            result.add(this.save(entity));
        }

        return result;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> propertyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds)
            if (!pd.getName().equals(DELETED_FIELD) && src.getPropertyValue(pd.getName()) == null)
                propertyNames.add(pd.getName());

        return propertyNames.toArray(new String[propertyNames.size()]);
    }


    private static final class ByIdSpecification<T, ID extends Serializable> implements Specification<T> {

        private final JpaEntityInformation<T, ?> entityInformation;
        private final ID id;

        public ByIdSpecification(JpaEntityInformation<T, ?> entityInformation, ID id) {
            this.entityInformation = entityInformation;
            this.id = id;
        }

        @Override
        public Predicate toPredicate(@NotNull Root<T> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder cb) {
            final List<Predicate> predicates = new ArrayList<>();
            if (entityInformation.hasCompositeId()) {
                for (String s : entityInformation.getIdAttributeNames())
                    predicates.add(cb.equal(root.<ID>get(s), entityInformation.getCompositeIdAttributeValue(id, s)));

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
            return cb.equal(root.<ID>get(requireNonNull(entityInformation.getIdAttribute(),"Id Attribute must not be null").getName()), id);
        }
    }


    @SuppressWarnings("rawtypes")
    private static final class ByIdsSpecification<T> implements Specification<T> {

        private final JpaEntityInformation<T, ?> entityInformation;
        ParameterExpression<Iterable> parameter;

        public ByIdsSpecification(JpaEntityInformation<T, ?> entityInformation) {
            this.entityInformation = entityInformation;
        }

        @Override
        public Predicate toPredicate(Root<T> root, @NotNull CriteriaQuery<?> query, CriteriaBuilder cb) {
            Path<?> path = root.get(entityInformation.getIdAttribute());
            parameter = cb.parameter(Iterable.class);
            return path.in(parameter);
        }
    }


    private static final class DeletedIsNull<T> implements Specification<T> {
        @Override
        public Predicate toPredicate(Root<T> root, @NotNull CriteriaQuery<?> query, CriteriaBuilder cb) {
            return cb.isNull(root.<LocalDateTime>get(DELETED_FIELD));
        }
    }

    private static final class DeletedTimeGreatherThanNow<T> implements Specification<T> {
        @Override
        public Predicate toPredicate(Root<T> root, @NotNull CriteriaQuery<?> query, CriteriaBuilder cb) {
            return cb.greaterThan(root.get(DELETED_FIELD), LocalDateTime.now());
        }
    }

    private static final <T> Specification<T> notDeleted() {
        return Specifications.where(new DeletedIsNull<T>()).or(new DeletedTimeGreatherThanNow<T>());
    }
}
