package org.ssh001.customer;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

/**
 * @author Administrator
 *
 * @param <T>
 * @param <ID>
 * �Զ���repository��������������baserepository
 */
public class BaseRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

	public BaseRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return BaseRepositoryImpl.class;
	}

	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
			RepositoryInformation information, EntityManager entityManager) {
		return new BaseRepositoryImpl(information.getDomainType(), entityManager);
	}

}
