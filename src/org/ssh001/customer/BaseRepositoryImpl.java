package org.ssh001.customer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * @author Administrator
 *
 * @param <T>
 * @param <ID>
 *            自定义repository实现类代替默认的simplerepository实现类作用为repository接口提供实现类
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private String domainType;
	private EntityManager em;

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.domainType = domainClass.getName();
		this.em = em;
	}

	@Override
	public boolean support(String modelType) {
		return domainType.equals(modelType);
	}

	@Override
	public List<?> find(String hql, Map<String, Object> map) {
		Set<Entry<String, Object>> es = map.entrySet();
		Query query = em.createQuery(hql);
		for (Entry<String, Object> entry : es) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		List pl = query.getResultList();
		return pl;
	}

}
