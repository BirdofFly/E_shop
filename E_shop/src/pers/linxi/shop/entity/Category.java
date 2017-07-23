package pers.linxi.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 一级分类表
 * 
 * @author 林曦
 * 
 */
public class Category {
	private Integer cid;
	private String cname;
	private Set<CategorySecond> csSet = new HashSet<CategorySecond>();

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

	public Set<CategorySecond> getCsSet() {
		return csSet;
	}

	public void setCsSet(Set<CategorySecond> csSet) {
		this.csSet = csSet;
	}

}
