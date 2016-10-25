package com.honglei.server;

import com.honglei.bean.User;

public interface LoginService {
	
	public String login(User user);
	
	/**
	 * 用户注册
	 * @param user
	 */
	public void insertNewUser(User user);
	
	
}
