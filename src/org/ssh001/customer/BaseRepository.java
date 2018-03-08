package org.ssh001.customer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Administrator
 *
 * @param <T>
 * @param <ID>
 * �Զ���repository�ӿڴ���spring data Ĭ�ϵ�repositiry
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	boolean support(String modelType);

	List<?> find(String hql, Map<String, Object> map);
}
