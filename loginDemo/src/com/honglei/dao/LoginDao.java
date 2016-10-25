package com.honglei.dao;

import com.honglei.bean.User;

public interface LoginDao {
	
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public User save(User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public String login(User user);
}
