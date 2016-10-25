package com.honglei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.honglei.bean.StaticValue;
import com.honglei.bean.User;
import com.honglei.server.LoginService;


@Controller
public class LoginController {//登录处理
	
	@Autowired
	private LoginService LoginService;
	
	private StaticValue staticvalue;
	
	@RequestMapping("/login")//登录页面
	public String login(ModelMap map){ 
		//登录页面
		return "/login/login";
	}
	
	/**
	 * 登录 
	 * @param user
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/logincheck")
	public String loginMethod(User user,HttpServletRequest request,ModelMap map) {
		
		//登录成功，跳转新页面
		HttpSession session = request.getSession();
		//登录操作。。。简单处理  
		String code = LoginService.login(user);
		if(staticvalue.LOGINSUCCESS.equals(code)){//登录成功
			return "/login/main";
		}else if(staticvalue.PASSWORDERROR.equals(code)){//登录失败，返回原页面，附带失败原因
			map.put("message", "用户名或密码错误！");
			return "/login/login";
		}else {
			return "/login/login";
		}
	}
	
	@RequestMapping("/sign")
	public String signMethod(){
		return "/login/sign";
	}
	
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/sign/save")
	public String insetNewUser(User user,ModelMap map){
		try {
			LoginService.insertNewUser(user);
		} catch (Exception e) {
			return "/login/login";
		}
		return "/login/success";
	}
}
