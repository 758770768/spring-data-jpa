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
 * @author Administrator spring data -jpa ������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/ssh001/cnf/app-core.xml")
public class JpaTestDemo {

	@Resource
	private ProductDaoJpa pd;

	@Resource
	private CustomerJpaDao cjd;

	/**
	 * oliver 2018��3��2�� ssh001 ����ͳ��
	 */
	@Test
	public void fn() {

		System.out.println(pd.count());

	}

	/**
	 * oliver 2018��3��2�� ssh001 �Զ�����ģ����ѯ
	 */
	@Test
	public void fn1() {

		System.out.println(pd.findByPmessStartingWith("��"));

	}

	/**
	 * oliver 2018��3��2�� ssh001 ��ҳ
	 */
	@Test
	public void fn2() {
		Page<Product> page = pd.findAll(new PageRequest(1, 1));
		System.out.println(page.getContent());
	}

	/**
	 * oliver 2018��3��2�� ssh001 ��������ҳ
	 */
	@Test
	public void fn3() {
		Page<Product> page = pd.findByPmessStartingWith("��", new PageRequest(0, 1));
		System.out.println(page.getContent());
	}

	/**
	 * oliver 2018��3��2�� ssh001 �Զ�������query��ѯ
	 */
	@Test
	public void fn4() {
		List<Product> page = pd.findByC("Ц��");
		System.out.println(page);
	}

	/**
	 * oliver 2018��3��2�� ssh001 �Զ����ѯָ����
	 */
	@Test
	public void fn5() {
		List<Product> page = pd.findByC1("Ц��");
		System.out.println(page);
	}

	/**
	 * oliver 2018��3��2�� ssh001 �Զ����ѯ��ѯ����
	 */
	@Test
	public void fn6() {
		List<Object[]> page = pd.findByC2("Ц��");
		for (Object[] o : page) {
			System.out.println(o[0] + ":" + o[1]);
		}

	}

	/**
	 * oliver 2018��3��2�� ssh001 ��ѯ����map
	 * 
	 */
	@Test
	public void fn7() {
		List<Map<String, String>> page = pd.findByC3("Ц��");
		System.out.println(page);
	}

	/**
	 * oliver 2018��3��2�� ssh001 �Զ���ӿ�
	 */
	@Test
	public void fn8() {
		String hql = "from Product where pname=:pname";
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", "�ɻ�");
		List<Product> pl = pd.findAll(hql, map);
		System.out.println(pl);
	}

	/**
	 * oliver 2018��3��3�� ssh001 �Զ���basedao�ӿڲ���
	 */
	/**
	 * oliver 2018��3��3�� ssh001 �Զ���ӿ��Զ��巽����ѯ
	 */
	@Test
	public void fn9() {
		boolean flag = cjd.support("Product");
		System.out.println(flag);
	}

	/**
	 * oliver 2018��3��3�� ssh001 �Զ���ӿ�����jpa�����淶����������ѯ
	 */
	@Test
	public void fn10() {
		List<Product> pl = cjd.findByPname("�ɻ�", new PageRequest(0, 1));
		System.out.println(pl);
	}

	/**
	 * oliver 2018��3��3�� ssh001 �Զ���ӿ�ʵ��hql��������ѯʵ��ȫ������
	 */
	@Test
	public void fn11() {
		String hql = "from Product  p where p.pname=:pname and p.catagory.cname=:cname";
		Map<String, Object> map = new HashMap<>();
		map.put("pname", "�ɻ�");
		map.put("cname", "Ц��");
		List<Product> pl = (List<Product>) cjd.find(hql, map);
		System.out.println(pl);
	}

	/**
	 * oliver 2018��3��3�� ssh001 �Զ���ӿ�ʵ��hql��������ѯʵ�岿��
	 */
	@Test
	public void fn12() {
		String hql = "select p.pname,p.catagory.cname from Product  p where p.pname=:pname and p.catagory.cname=:cname";
		Map<String, Object> map = new HashMap<>();
		map.put("pname", "�ɻ�");
		map.put("cname", "Ц��");
		List<Object[]> pl = (List<Object[]>) cjd.find(hql, map);
		for (Object[] objects : pl) {
			System.out.println(objects[0] + "  " + objects[1]);
		}
	}

}
