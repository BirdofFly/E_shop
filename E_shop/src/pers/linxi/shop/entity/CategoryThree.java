package pers.linxi.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 三级分类的实体类
 * 
 * @author 林曦
 * 
 */
public class CategoryThree {
	private Integer ctid; // 三级分类id
	private String ctname; // 三级分类名称
	private CategorySecond categorySecond; // 所属的二级分类
	private Set<Product> pSet = new HashSet<Product>(); // 对应的商品的集合

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getCtname() {
		return ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Set<Product> getpSet() {
		return pSet;
	}

	public void setpSet(Set<Product> pSet) {
		this.pSet = pSet;
	}

}
