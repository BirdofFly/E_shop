package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.UserDao;
import pers.linxi.shop.entity.User;
import pers.linxi.shop.util.EmailUtil;
import pers.linxi.shop.util.UUIDUtil;

/**
 * 用户模块的业务层
 * 
 * @author 林曦
 * 
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 查询用户的方法
	 */
	public User findByUser(String str) {
		return userDao.findByUser(str);
	}

	/**
	 * 业务层保存用户的方法
	 */
	public void save(User user) {
		user.setState(0); // 0代表用户未激活
		String code = UUIDUtil.getUUID();
		user.setCode(code);
		userDao.save(user);
		// 发送激活邮件
		//EmailUtil.sendMail(user.getEmail(), code);
	}

	/**
	 * 用户修改
	 * 
	 * @param exisUser
	 */
	public void update(User exisUser) {
		userDao.update(exisUser);
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return userDao.login(user);
	}
}
