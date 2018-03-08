package org.ssh001.jpa;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ssh001.pojo.Product;

/**
 * @author Administrator
 *继承spring data 默认repository 
 *并且添加@query注解实现连表查询
 */
public interface ProductDaoJpa extends JpaRepository<Product, Integer>, JPACustomer {

	public List<Product> findByPmessStartingWith(String leftLike);

	public Page<Product> findByPmessStartingWith(String leftLike, Pageable page);

	@Query(value = "select p from Product p inner join p.catagory c where c.cmess=?")
	public List<Product> findByC(String cname);

	@Query(value = "select p.pname   from Product p inner join   p.catagory c where c.cmess=?")
	public List<Product> findByC1(String cname);

	@Query(value = "select p.pname,c.cmess   from Product p inner join   p.catagory c where c.cmess=?")
	public List<Object[]> findByC2(String cname);

	@Query(value = "select new Map(p.pname,c.cmess)   from Product p inner join   p.catagory c where c.cmess=?")
	public List<Map<String, String>> findByC3(String cname);

}
