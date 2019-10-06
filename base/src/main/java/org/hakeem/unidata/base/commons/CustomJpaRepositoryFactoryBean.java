package org.hakeem.unidata.base.commons;


import org.hakeem.unidata.repositories.UnidataCrudRepositoryImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;


/**
 *
 * @author Kristijan Georgiev
 *
 *         Returns the custom repository implementation for the soft deletes
 */

public class CustomJpaRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<T, S, ID> {

    public CustomJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }


    @NotNull
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomJpaRepositoryFactory<T, ID>(entityManager);
    }

    private static class CustomJpaRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

        private final EntityManager entityManager;

        public CustomJpaRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

//        @Override
//        @SuppressWarnings("unchecked")
//        protected Object getTargetRepository(RepositoryInformation information) {
//            return new UnidataCrudRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
//        }

        @NotNull
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return UnidataCrudRepositoryImpl.class;
        }
    }
}