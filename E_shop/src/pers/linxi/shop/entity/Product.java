package pers.linxi.shop.entity;

import java.util.Date;

/**
 * ��Ʒ��
 * 
 * @author ����
 * 
 */
public class Product {
	private Integer pid; // ��Ʒid
	private String pname; // ��Ʒ����
	private double marketPrice; // �г���
	private double shopPrice; // �̳Ǽ�
	private String image; // ͼƬ
	private Integer number; // ����
	private String pdescribe; // ����
	private Integer ifHot; // �Ƿ�����
	private Date pdate; // ʱ��
	private CategoryThree categoryThree; // ��������������

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPdescribe() {
		return pdescribe;
	}

	public void setPdescribe(String pdescribe) {
		this.pdescribe = pdescribe;
	}

	public Integer getIfHot() {
		return ifHot;
	}

	public void setIfHot(Integer ifHot) {
		this.ifHot = ifHot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public CategoryThree getCategoryThree() {
		return categoryThree;
	}

	public void setCategoryThree(CategoryThree categoryThree) {
		this.categoryThree = categoryThree;
	}

}
