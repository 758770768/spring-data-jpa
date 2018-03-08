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
 * @author Administrator hibernate方法封装
 */
@Repository//在容器中创建对象
@Transactional//加入事务管理
public class ProductDao extends HibernateDaoSupport {

	/**
	 * oliver 2018年1月29日 ssh001 将sessionfactory对象注入此类
	 */
	@Resource
	public void set(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	/**
	 * oliver 2018年1月29日 ssh001 查询所有商品只能查询所有无法添加条件
	 */
	public List<Product> query() {
		// 获得hibernate框架写好的增删改查方法对象
		HibernateTemplate jdbc = getHibernateTemplate();
		List<Product> pl = jdbc.loadAll(Product.class);
		System.out.println(pl);
		return pl;

	}

	/**
	 * oliver 2018年1月29日 ssh001 
	 * hql实现查询所有带条件和排序
	 */
	public List<Product> query(String hql) {
		// 获得hibernate框架写好的增删改查方法对象
		HibernateTemplate jdbc = getHibernateTemplate();
		List<Product> pl = (List<Product>) jdbc.find(hql);
		return pl;
		
	}

}
