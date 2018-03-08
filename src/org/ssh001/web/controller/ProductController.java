package org.ssh001.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssh001.dao.CatagoryDao;
import org.ssh001.dao.ProductDao;
import org.ssh001.pojo.Product;

/**
 * @author Administrator ��Ʒ������
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired // ��ע���resourceע��Ч��һ��
	private ProductDao pd;

	@Resource
	private CatagoryDao cd;

	@RequestMapping("/list")
//	����ֵΪ�յ�ʱ��������urlΪjsp������ȥ��ͼ������ƴ·��
	public void fn(String pname, String order,String cid, ModelMap map) {
		// hql
		String hql = " from Product where 1=1";
		// ƴ��ģ����ѯ����
		if (null != pname && !"".equals(pname)) {
			hql += " and pname like '%" + pname + "%' ";

		}
//		���ݷ���id��ѯ��Ӧ��������Ĳ�Ʒhqlƴ��
		if(null!=cid&&!"".equals(cid)){
			hql+=" and catagory.cid="+cid;
		}
		// ƴ����������
		if (null != order && !"".equals(order)) {
			hql += "  order by  pid " + order;
		}

		// ��ѯ������Ʒ��Ϣ
		List<Product> pl = pd.query(hql);
		// ������ŵ�����
		map.put("ps", pl);
//		��������Ϣ�ŵ�����
		map.put("cl", cd.query());
//		����ѯ�ķ���id����
		map.put("cid", cid);
//		��ģ����ѯ����Ʒ������
		map.put("pname", pname);

	}

}
