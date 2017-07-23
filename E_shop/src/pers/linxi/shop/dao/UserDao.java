package pers.linxi.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.linxi.shop.entity.User;

/**
 * 用户模块的持久层
 * 
 * @author 林曦
 * 
 */
public class UserDao extends HibernateDaoSupport {

	/**
	 * 查询用户的方法
	 */
	public User findByUser(String str) {
		String hql;
		if (str.length() == 32)
			hql = "from User where code = ?";
		else
			hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, str);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 用户修改
	 * 
	 * @param exisUser
	 */
	public void update(User exisUser) {
		this.getHibernateTemplate().update(exisUser);
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = 1";
		List<User> list = this.getHibernateTemplate().find(hql,
				user.getUsername(), user.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
