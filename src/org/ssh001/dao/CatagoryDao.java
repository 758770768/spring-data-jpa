package org.ssh001.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ssh001.pojo.Catagory;

@Repository
@Transactional
public class CatagoryDao extends HibernateDaoSupport {

	/**
	 * oliver 2018年1月29日 ssh001 将sessionfactory对象注入此类
	 */
	@Resource
	public void set(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	/**
	 * oliver 2018年1月29日 ssh001 查询所有分类
	 */
	public List<Catagory> query() {
		HibernateTemplate jdbc = getHibernateTemplate();
		List<Catagory> cl = jdbc.loadAll(Catagory.class);
		return cl;
	}

}
