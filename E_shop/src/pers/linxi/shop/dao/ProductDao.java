package pers.linxi.shop.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.linxi.shop.entity.Product;
import pers.linxi.shop.util.PageHibernateCallback;

/**
 * 商品模块的Dao
 * 
 * @author 林曦
 * 
 */
public class ProductDao extends HibernateDaoSupport {

	/**
	 * 查询热门和最新商品
	 * 
	 * @return
	 */
	public List<Product> findHotNew(boolean result) {
		// 使用离线查询
		DetachedCriteria creteria = DetachedCriteria.forClass(Product.class);
		// 加入条件查询，如果result结果为true，那么查询条件为is_hot=1，否则不进行条件查询
		if (result) {
			creteria.add(Restrictions.eq("ifHot", 1));
		}
		// 查询出的结果按倒序排序
		creteria.addOrder(Order.desc("pdate"));
		List<Product> pList = this.getHibernateTemplate().findByCriteria(
				creteria, 0, 10);
		return pList;
	}

	/**
	 * 根据商品的id查询商品
	 */
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	/**
	 * 根据对应分类id查询商品总记录数
	 * 
	 * @param cid
	 * @return
	 */
	public int findCountCid(Integer cid,int id) {
		String hql = null;
		if(id == 1)
			hql = "select count(*) from Product p where p.categoryThree.categorySecond.category.cid = ?";
		else if(id == 2)
			hql = "select count(*) from Product p where p.categoryThree.categorySecond.csid = ?";
		else if(id == 3)
			hql = "select count(*) from Product p where p.categoryThree.ctid = ?";
		List<Long> cList = this.getHibernateTemplate().find(hql, cid);
		// list集合有数据时，转成int类型的集合
		if (cList != null && cList.size() > 0)
			return cList.get(0).intValue();
		return 0;
	}

	/**
	 * 根据对应分类的id查询每页商品的集合
	 * 
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit,int id) {
		// 利用join使用多表查询的hql
		String hql = null;
		//查询一级分类下的所有商品
		if(id == 1)
			hql = "select p from Product p join p.categoryThree ct join ct.categorySecond cs where cs.csid = ?";
		//查询二级分类下的所有商品
		else if(id == 2)
			hql = "select p from Product p join p.categoryThree ct join ct.categorySecond cs where cs.csid = ?";
		//查询三级分类下的所有商品
		else if(id == 3)
			hql = "select p from Product p join p.categoryThree ct  where ct.ctid = ?";
		List<Product> pList = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[] { cid },
						begin, limit));
		if (pList != null && pList.size() > 0)
			return pList;
		return null;
	}

}
