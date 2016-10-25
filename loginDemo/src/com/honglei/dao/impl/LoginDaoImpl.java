package com.honglei.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.honglei.bean.StaticValue;
import com.honglei.bean.User;
import com.honglei.dao.LoginDao;
import com.mysql.jdbc.StringUtils;


public class LoginDaoImpl implements LoginDao {
	
	private StaticValue staticvalue;
	/**
	 * 新增用户
	 */
	@Override
	public User save(User user) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("insert into user(name,sex,email,phone,password) values (?,?,?,?,?)");
		try {
			Connection conn = this.getConnection();
			PreparedStatement pre = conn.prepareStatement(buffer.toString());
			pre.setString(1, user.getName());
			pre.setInt(2, user.getSex());
			pre.setString(3, user.getEmail());
			pre.setString(4, user.getPhone());
			pre.setString(5, user.getPassword());
			pre.execute();
			ResultSet rs = null;
			this.close(pre, rs, conn);
		} catch (Exception e) {
		}
		
		return user;
	}
	
	@Override
	public String login(User user) {
		String name = user.getName();//登录用户名
		String password = user.getPassword();//登录密码
		String sql = "select * from user where name=?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet rs = pre.executeQuery();
			String pass="";
			while (rs.next()) {
				pass = rs.getString("password");
			}
			
			if (!password.equals(pass)) {
				return staticvalue.PASSWORDERROR;//登录密码错误
			}
			
			this.close(pre, rs, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staticvalue.LOGINSUCCESS;
	}






	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");	
			String url = "jdbc:mysql://localhost:3306/honglei_test?useUnicode=true&amp;characterEncoding=UTF-8";
			String useranme = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, useranme, password);
			return conn;
			
		} catch (Exception e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
	}
	
	
	public static void close(Statement st,ResultSet rs,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭连接记录集异常！");
				e.printStackTrace();
			}
			
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("关系声明异常");
					e.printStackTrace();
				}
			}
			
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("关闭连接异常！");
					e.printStackTrace();
				}
			}
		}
		
	}
	
	

}
