package com.czy.op.serviceImpl;

import com.czy.op.model.User;
import com.czy.op.dao.UserDao;
import com.czy.op.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	/*属性*/
	@Resource
	private UserDao userDao;
	/**
	 * 用户名检测
	 */
	public User searchUserByName(User user) {
		return userDao.searchUserByName(user);
	}
	/**
	 * 用户注册
	 */
	public void register(User user) {
		userDao.register(user);
	}
	/**
	 * 用户登录
	 */
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}
}
