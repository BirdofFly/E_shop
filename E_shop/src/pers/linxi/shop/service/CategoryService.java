package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.CategoryDao;
import pers.linxi.shop.entity.Category;

/**
 * 一级分类的业务层
 * @author 林曦
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	/**
	 * 查询所有一级分类
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
