package pers.linxi.shop.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.linxi.shop.entity.Product;
import pers.linxi.shop.util.PageHibernateCallback;

/**
 * ��Ʒģ���Dao
 * 
 * @author ����
 * 
 */
public class ProductDao extends HibernateDaoSupport {

	/**
	 * ��ѯ���ź�������Ʒ
	 * 
	 * @return
	 */
	public List<Product> findHotNew(boolean result) {
		// ʹ�����߲�ѯ
		DetachedCriteria creteria = DetachedCriteria.forClass(Product.class);
		// ����������ѯ�����result���Ϊtrue����ô��ѯ����Ϊis_hot=1�����򲻽���������ѯ
		if (result) {
			creteria.add(Restrictions.eq("ifHot", 1));
		}
		// ��ѯ���Ľ������������
		creteria.addOrder(Order.desc("pdate"));
		List<Product> pList = this.getHibernateTemplate().findByCriteria(
				creteria, 0, 10);
		return pList;
	}

	/**
	 * ������Ʒ��id��ѯ��Ʒ
	 */
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	/**
	 * ���ݶ�Ӧ����id��ѯ��Ʒ�ܼ�¼��
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
		// list����������ʱ��ת��int���͵ļ���
		if (cList != null && cList.size() > 0)
			return cList.get(0).intValue();
		return 0;
	}

	/**
	 * ���ݶ�Ӧ�����id��ѯÿҳ��Ʒ�ļ���
	 * 
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit,int id) {
		// ����joinʹ�ö���ѯ��hql
		String hql = null;
		//��ѯһ�������µ�������Ʒ
		if(id == 1)
			hql = "select p from Product p join p.categoryThree ct join ct.categorySecond cs where cs.csid = ?";
		//��ѯ���������µ�������Ʒ
		else if(id == 2)
			hql = "select p from Product p join p.categoryThree ct join ct.categorySecond cs where cs.csid = ?";
		//��ѯ���������µ�������Ʒ
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
