package pers.linxi.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������ʵ����
 * 
 * @author ����
 * 
 */
public class CategoryThree {
	private Integer ctid; // ��������id
	private String ctname; // ������������
	private CategorySecond categorySecond; // �����Ķ�������
	private Set<Product> pSet = new HashSet<Product>(); // ��Ӧ����Ʒ�ļ���

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
