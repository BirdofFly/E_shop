package pers.linxi.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.linxi.shop.entity.Category;
/**
 * 一级分类的Dao
 * @author 林曦
 *
 */
public class CategoryDao extends HibernateDaoSupport {
	/**
	 * 查询所有一级分类
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
