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
 * @author Administrator 商品处理器
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired // 此注解和resource注解效果一致
	private ProductDao pd;

	@Resource
	private CatagoryDao cd;

	@RequestMapping("/list")
//	返回值为空的时候以请求url为jsp的名字去视图解析器拼路径
	public void fn(String pname, String order,String cid, ModelMap map) {
		// hql
		String hql = " from Product where 1=1";
		// 拼接模糊查询条件
		if (null != pname && !"".equals(pname)) {
			hql += " and pname like '%" + pname + "%' ";

		}
//		依据分类id查询相应分类下面的产品hql拼接
		if(null!=cid&&!"".equals(cid)){
			hql+=" and catagory.cid="+cid;
		}
		// 拼接排序条件
		if (null != order && !"".equals(order)) {
			hql += "  order by  pid " + order;
		}

		// 查询所有商品信息
		List<Product> pl = pd.query(hql);
		// 将结果放到域中
		map.put("ps", pl);
//		将分类信息放到域中
		map.put("cl", cd.query());
//		将查询的分类id回显
		map.put("cid", cid);
//		将模糊查询的商品名回显
		map.put("pname", pname);

	}

}
