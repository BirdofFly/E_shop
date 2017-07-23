package pers.linxi.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 二级分类的实体类
 * 
 * @author 林曦
 * 
 */
public class CategorySecond {
	private Integer csid; // 二级分类id
	private String csname; // 二级分类名称
	private Category category; // 所属的一级分类
	private Set<CategoryThree> ctSet = new HashSet<CategoryThree>(); // 对应的三级分类

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<CategoryThree> getCtSet() {
		return ctSet;
	}

	public void setCtSet(Set<CategoryThree> ctSet) {
		this.ctSet = ctSet;
	}

}
