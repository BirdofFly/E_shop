package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.CategoryDao;
import pers.linxi.shop.entity.Category;

/**
 * һ�������ҵ���
 * @author ����
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	/**
	 * ��ѯ����һ������
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
