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
 * ������ҳ��Action
 * 
 * @author ����
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
	 * ִ�з�����ҳ�ķ���
	 */
	public String execute() {
		//��ѯһ������
		List<Category> cList = categoryService.findAll();
		//���ҳ����Ҫ��ѯ���Ľ�������Խ����ݱ�����Session��
		ActionContext.getContext().getSession().put("cList", cList);
		//��ѯ������Ʒ
		List<Product> hList = productService.findHotNew(true);
		//ֻ����ҳ��Ҫ��ѯ����������Ʒ�Ľ�������Խ����ݱ�����ֵջ��
		ActionContext.getContext().getValueStack().set("hList", hList);
		//��ѯ������Ʒ
		List<Product> nList = productService.findHotNew(false);
		//ֻ����ҳ��Ҫ��ѯ����������Ʒ�Ľ�������Խ����ݱ�����ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	
	
}
