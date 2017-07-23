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
 * ��Ʒ��Action
 * 
 * @author ����
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private Product product = new Product();
	private ProductService productService;
	private Integer cid; // ҳ�洫�ݹ�����һ������id
	private Integer csid;// ҳ�洫�ݹ����Ķ�������id
	private Integer ctid;// ҳ�洫�ݹ�������������id

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	private int page; // ҳ�洫�ݹ����ĵ�ǰҳ��
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
	 * ������Ʒ��id��ѯ��Ʒ
	 */
	public String findByPid() {
		//��cid����ֵջ�У��Ա������������ʱʹ��
		ActionContext.getContext().getValueStack().set("ccid", cid);
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	/**
	 * ���ݶ�Ӧ�ķ���id��ѯ��Ӧ�����µ���Ʒ
	 * 
	 * @return
	 */
	public String findByCid() {
		//��cid����ֵջ�У��Ա������������ʱʹ��
		ActionContext.getContext().getValueStack().set("ccid", cid);
		Paging<Product> paging = null;
		// �������������ѯ����ҳ����Ʒ
		if (ctid != null)
			paging = productService.findByPageCid(ctid, page, 3);
		// ���ݶ��������ѯ����ҳ����Ʒ
		else if (csid != null)
			paging = productService.findByPageCid(csid, page, 2);
		// ����һ�������ѯ����ҳ����Ʒ
		else if (cid != null) {
			paging = productService.findByPageCid(cid, page, 1);
		}
		// ����ȡ����paging������뵽ֵջ��
		ActionContext.getContext().getValueStack().set("paging", paging);
		return "findByCid";
	}
}
