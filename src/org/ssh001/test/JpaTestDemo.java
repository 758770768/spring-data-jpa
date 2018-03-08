package org.ssh001.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ssh001.jpa.CustomerJpaDao;
import org.ssh001.jpa.ProductDaoJpa;
import org.ssh001.pojo.Product;

/**
 * @author Administrator spring data -jpa 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/ssh001/cnf/app-core.xml")
public class JpaTestDemo {

	@Resource
	private ProductDaoJpa pd;

	@Resource
	private CustomerJpaDao cjd;

	/**
	 * oliver 2018年3月2日 ssh001 测试统计
	 */
	@Test
	public void fn() {

		System.out.println(pd.count());

	}

	/**
	 * oliver 2018年3月2日 ssh001 自定义左模糊查询
	 */
	@Test
	public void fn1() {

		System.out.println(pd.findByPmessStartingWith("玩"));

	}

	/**
	 * oliver 2018年3月2日 ssh001 分页
	 */
	@Test
	public void fn2() {
		Page<Product> page = pd.findAll(new PageRequest(1, 1));
		System.out.println(page.getContent());
	}

	/**
	 * oliver 2018年3月2日 ssh001 带条件分页
	 */
	@Test
	public void fn3() {
		Page<Product> page = pd.findByPmessStartingWith("车", new PageRequest(0, 1));
		System.out.println(page.getContent());
	}

	/**
	 * oliver 2018年3月2日 ssh001 自定义连表query查询
	 */
	@Test
	public void fn4() {
		List<Product> page = pd.findByC("笑话");
		System.out.println(page);
	}

	/**
	 * oliver 2018年3月2日 ssh001 自定义查询指定列
	 */
	@Test
	public void fn5() {
		List<Product> page = pd.findByC1("笑话");
		System.out.println(page);
	}

	/**
	 * oliver 2018年3月2日 ssh001 自定义查询查询几列
	 */
	@Test
	public void fn6() {
		List<Object[]> page = pd.findByC2("笑话");
		for (Object[] o : page) {
			System.out.println(o[0] + ":" + o[1]);
		}

	}

	/**
	 * oliver 2018年3月2日 ssh001 查询返回map
	 * 
	 */
	@Test
	public void fn7() {
		List<Map<String, String>> page = pd.findByC3("笑话");
		System.out.println(page);
	}

	/**
	 * oliver 2018年3月2日 ssh001 自定义接口
	 */
	@Test
	public void fn8() {
		String hql = "from Product where pname=:pname";
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", "飞机");
		List<Product> pl = pd.findAll(hql, map);
		System.out.println(pl);
	}

	/**
	 * oliver 2018年3月3日 ssh001 自定义basedao接口测试
	 */
	/**
	 * oliver 2018年3月3日 ssh001 自定义接口自定义方法查询
	 */
	@Test
	public void fn9() {
		boolean flag = cjd.support("Product");
		System.out.println(flag);
	}

	/**
	 * oliver 2018年3月3日 ssh001 自定义接口依照jpa命名规范创建方法查询
	 */
	@Test
	public void fn10() {
		List<Product> pl = cjd.findByPname("飞机", new PageRequest(0, 1));
		System.out.println(pl);
	}

	/**
	 * oliver 2018年3月3日 ssh001 自定义接口实现hql带条件查询实体全部属性
	 */
	@Test
	public void fn11() {
		String hql = "from Product  p where p.pname=:pname and p.catagory.cname=:cname";
		Map<String, Object> map = new HashMap<>();
		map.put("pname", "飞机");
		map.put("cname", "笑话");
		List<Product> pl = (List<Product>) cjd.find(hql, map);
		System.out.println(pl);
	}

	/**
	 * oliver 2018年3月3日 ssh001 自定义接口实现hql带条件查询实体部分
	 */
	@Test
	public void fn12() {
		String hql = "select p.pname,p.catagory.cname from Product  p where p.pname=:pname and p.catagory.cname=:cname";
		Map<String, Object> map = new HashMap<>();
		map.put("pname", "飞机");
		map.put("cname", "笑话");
		List<Object[]> pl = (List<Object[]>) cjd.find(hql, map);
		for (Object[] objects : pl) {
			System.out.println(objects[0] + "  " + objects[1]);
		}
	}

}
