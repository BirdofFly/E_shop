package pers.linxi.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.linxi.shop.entity.Category;
/**
 * һ�������Dao
 * @author ����
 *
 */
public class CategoryDao extends HibernateDaoSupport {
	/**
	 * ��ѯ����һ������
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
