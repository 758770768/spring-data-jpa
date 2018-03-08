package org.ssh001.dao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ssh001.pojo.Product;

/**
 * @author Administrator hibernate������װ
 */
@Repository//�������д�������
@Transactional//�����������
public class ProductDao extends HibernateDaoSupport {

	/**
	 * oliver 2018��1��29�� ssh001 ��sessionfactory����ע�����
	 */
	@Resource
	public void set(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	/**
	 * oliver 2018��1��29�� ssh001 ��ѯ������Ʒֻ�ܲ�ѯ�����޷��������
	 */
	public List<Product> query() {
		// ���hibernate���д�õ���ɾ�Ĳ鷽������
		HibernateTemplate jdbc = getHibernateTemplate();
		List<Product> pl = jdbc.loadAll(Product.class);
		System.out.println(pl);
		return pl;

	}

	/**
	 * oliver 2018��1��29�� ssh001 
	 * hqlʵ�ֲ�ѯ���д�����������
	 */
	public List<Product> query(String hql) {
		// ���hibernate���д�õ���ɾ�Ĳ鷽������
		HibernateTemplate jdbc = getHibernateTemplate();
		List<Product> pl = (List<Product>) jdbc.find(hql);
		return pl;
		
	}

}
