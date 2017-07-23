package pers.linxi.shop.action;

import java.util.List;

import pers.linxi.shop.entity.Category;
import pers.linxi.shop.entity.Product;
import pers.linxi.shop.entity.User;
import pers.linxi.shop.service.CategoryService;
import pers.linxi.shop.service.ProductService;
import pers.linxi.shop.util.Paging;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品的Action
 * 
 * @author 林曦
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private Product product = new Product();
	private ProductService productService;
	private Integer cid; // 页面传递过来的一级分类id
	private Integer csid;// 页面传递过来的二级分类id
	private Integer ctid;// 页面传递过来的三级分类id

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	private int page; // 页面传递过来的当前页数
	private CategoryService categoryService;

	@Override
	public Product getModel() {
		return product;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 根据商品的id查询商品
	 */
	public String findByPid() {
		//将cid存入值栈中，以便遍历分类名称时使用
		ActionContext.getContext().getValueStack().set("ccid", cid);
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	/**
	 * 根据对应的分类id查询对应分类下的商品
	 * 
	 * @return
	 */
	public String findByCid() {
		//将cid存入值栈中，以便遍历分类名称时使用
		ActionContext.getContext().getValueStack().set("ccid", cid);
		Paging<Product> paging = null;
		// 根据三级分类查询带分页的商品
		if (ctid != null)
			paging = productService.findByPageCid(ctid, page, 3);
		// 根据二级分类查询带分页的商品
		else if (csid != null)
			paging = productService.findByPageCid(csid, page, 2);
		// 根据一级分类查询带分页的商品
		else if (cid != null) {
			paging = productService.findByPageCid(cid, page, 1);
		}
		// 将获取到的paging对象存入到值栈中
		ActionContext.getContext().getValueStack().set("paging", paging);
		return "findByCid";
	}
}
