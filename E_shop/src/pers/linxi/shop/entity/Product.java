package pers.linxi.shop.entity;

import java.util.Date;

/**
 * 商品类
 * 
 * @author 林曦
 * 
 */
public class Product {
	private Integer pid; // 商品id
	private String pname; // 商品名称
	private double marketPrice; // 市场价
	private double shopPrice; // 商城价
	private String image; // 图片
	private Integer number; // 数量
	private String pdescribe; // 描述
	private Integer ifHot; // 是否热门
	private Date pdate; // 时间
	private CategoryThree categoryThree; // 所属的三级分类

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
