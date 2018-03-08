package org.ssh001.jpa;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.ssh001.pojo.Product;

/**
 * @author Administrator 简单自定义接口实现自定义方法非spring data 默认命名规范
 */
public class ProductDaoJpaImpl implements JPACustomer<Product, Integer> {

	@Resource
	private EntityManager em;

	@Override
	public void say() {

		System.out.println("hello");
	}

	/*
	 * @author oliver ssh001 2018年3月2日 查询
	 */

	public List<Product> findAll(String hql, Map<String, Object> map) {
		Query query = em.createQuery(hql);
		Set<Entry<String, Object>> es = map.entrySet();
		for (Entry<String, Object> entry : es) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		List pl = query.getResultList();
		return pl;
	}

}
