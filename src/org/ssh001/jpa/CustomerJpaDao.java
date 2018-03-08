package org.ssh001.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.ssh001.customer.BaseRepository;
import org.ssh001.pojo.Product;

/**
 * @author Administrator �̳��Զ��幤��ʹ���Զ��巽��
 */
public interface CustomerJpaDao extends BaseRepository<Product, Integer> {

	List<Product> findByPname(String pname, Pageable page);

}
