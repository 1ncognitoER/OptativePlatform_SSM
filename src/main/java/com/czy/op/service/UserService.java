package com.czy.op.service;

import com.czy.op.model.User;

public interface UserService {
	/**
	 * 根据名称查询用户
	 * @param user
	 * @return
	 */
	public User searchUserByName(User user);
	/**
	 * 用户注册
	 * @param user
	 */
	public void register(User user);
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
	
}
