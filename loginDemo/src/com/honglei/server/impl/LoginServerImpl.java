package com.honglei.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honglei.bean.StaticValue;
import com.honglei.bean.User;
import com.honglei.dao.LoginDao;
import com.honglei.dao.impl.LoginDaoImpl;
import com.honglei.server.LoginService;

@Service
public class LoginServerImpl implements LoginService {

	
	private StaticValue staticvalue;
	
	
	@Override
	public String login(User user) {
		
		LoginDao loginDao = new LoginDaoImpl();
		String code = loginDao.login(user);
		return code;
	}


	@Override
	public void insertNewUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.save(user);
	}

}
