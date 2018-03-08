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
 * @author Administrator ���Զ���ӿ�ʵ���Զ��巽����spring data Ĭ�������淶
 */
public class ProductDaoJpaImpl implements JPACustomer<Product, Integer> {

	@Resource
	private EntityManager em;

	@Override
	public void say() {

		System.out.println("hello");
	}

	/*
	 * @author oliver ssh001 2018��3��2�� ��ѯ
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
