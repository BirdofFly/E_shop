package pers.linxi.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������ʵ����
 * 
 * @author ����
 * 
 */
public class CategorySecond {
	private Integer csid; // ��������id
	private String csname; // ������������
	private Category category; // ������һ������
	private Set<CategoryThree> ctSet = new HashSet<CategoryThree>(); // ��Ӧ����������

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
