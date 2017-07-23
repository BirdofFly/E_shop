package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.UserDao;
import pers.linxi.shop.entity.User;
import pers.linxi.shop.util.EmailUtil;
import pers.linxi.shop.util.UUIDUtil;

/**
 * �û�ģ���ҵ���
 * 
 * @author ����
 * 
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * ��ѯ�û��ķ���
	 */
	public User findByUser(String str) {
		return userDao.findByUser(str);
	}

	/**
	 * ҵ��㱣���û��ķ���
	 */
	public void save(User user) {
		user.setState(0); // 0�����û�δ����
		String code = UUIDUtil.getUUID();
		user.setCode(code);
		userDao.save(user);
		// ���ͼ����ʼ�
		//EmailUtil.sendMail(user.getEmail(), code);
	}

	/**
	 * �û��޸�
	 * 
	 * @param exisUser
	 */
	public void update(User exisUser) {
		userDao.update(exisUser);
	}

	/**
	 * �û���¼
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return userDao.login(user);
	}
}
