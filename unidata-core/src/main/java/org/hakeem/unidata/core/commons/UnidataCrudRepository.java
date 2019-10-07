package org.hakeem.unidata.core.commons;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * base crud repository , implementing soft-delete technique
 * @param <T> Type of entity
 * @param <ID>  Type of Entity Id
 *
 * @author  abiel
 */
@Transactional
@NoRepositoryBean
public interface UnidataCrudRepository<T extends BaseEntity, ID extends UUID>  extends PagingAndSortingRepository<T, ID> {

    @NotNull
    @Override
    List<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);

    T findOne(ID id);

    //Look up deleted entities
    List<T> findDeleted();

    @Override
    long count();

    boolean exists(ID id) ;

    @Modifying
    @Transactional
    void delete(ID id);

    @Override
    @Transactional
    void delete(@NotNull T entity) ;

    void delete(Iterable<? extends T> entities) ;

    @Override
    @Modifying
    void deleteAll();

    <S extends T> List<S> save(Iterable<S> entities);
}
