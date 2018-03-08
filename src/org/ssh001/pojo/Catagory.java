package org.ssh001.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Administrator 分类实体类
 */
@Entity
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private String cmess;
	/*
	 * 一对多关系
	 * @OneToMany
	private Set<Product> ps;*/

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmess() {
		return cmess;
	}

	public void setCmess(String cmess) {
		this.cmess = cmess;
	}

}
