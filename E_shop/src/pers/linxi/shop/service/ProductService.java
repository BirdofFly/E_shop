package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.ProductDao;
import pers.linxi.shop.entity.Product;
import pers.linxi.shop.util.Paging;

/**
 * 商品的业务层
 * 
 * @author 林曦
 * 
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * 查询热门商品
	 * 
	 * @return
	 */
	public List<Product> findHotNew(boolean result) {
		List<Product> list = productDao.findHotNew(result);
		return list;
	}

	/**
	 * 根据id查询商品
	 * 
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	/**
	 * 根据对应的分类id查询带分页的商品
	 * 
	 * @param cid
	 * @param page
	 * @return
	 */
	public Paging<Product> findByPageCid(Integer cid, int page,int id) {
		Paging<Product> paging = new Paging<Product>();
		//设置当前页数
		paging.setPage(page);
		//设置每页显示的记录数
		int limit = 8;
		paging.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		//id=1时，执行查询一级分类下所有商品的总记录数
		totalCount = productDao.findCountCid(cid,id);
		paging.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		totalPage = (int) Math.ceil(totalCount/limit) + 1;
		paging.setTotalPage(totalPage);
		//设置每页显示的集合数据
		int begin = (page -1) * limit;
		List<Product> pList = productDao.findByPageCid(cid,begin,limit,id);
		paging.setList(pList);
		return paging;
	}

}
