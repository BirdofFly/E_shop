package pers.linxi.shop.action;

import java.util.List;
import java.util.Set;

import pers.linxi.shop.entity.Category;
import pers.linxi.shop.entity.CategorySecond;
import pers.linxi.shop.entity.CategoryThree;
import pers.linxi.shop.entity.Product;
import pers.linxi.shop.service.CategoryService;
import pers.linxi.shop.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问首页的Action
 * 
 * @author 林曦
 * 
 */
public class IndexAction extends ActionSupport {
	private CategoryService categoryService;
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	/**
	 * 执行访问首页的方法
	 */
	public String execute() {
		//查询一级分类
		List<Category> cList = categoryService.findAll();
		//多个页面需要查询到的结果，所以将数据保留到Session中
		ActionContext.getContext().getSession().put("cList", cList);
		//查询热门商品
		List<Product> hList = productService.findHotNew(true);
		//只有首页需要查询到的热门商品的结果，所以将数据保留到值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
		//查询最新商品
		List<Product> nList = productService.findHotNew(false);
		//只有首页需要查询到的最新商品的结果，所以将数据保留到值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	
	
}
