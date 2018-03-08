package org.ssh001.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.NoRepositoryBean;
import org.ssh001.pojo.Product;

/**
 * @author Administrator
 *
 * @param <T>
 * @param <S>
 *            简单自定义repository无法实现通用
 */
@NoRepositoryBean
public interface JPACustomer<T, S extends Serializable> {

	void say();

	List<T> findAll(String hql, Map<String, Object> map);
}
