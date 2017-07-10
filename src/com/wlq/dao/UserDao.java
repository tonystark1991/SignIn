package com.wlq.dao;
import java.sql.*;

import com.wlq.dao.ConnectDB;
import com.wlq.User;
public class UserDao {
	//添加用户，用户注册
	public void saveUser(User user){
		Connection con=ConnectDB.getConnection();
		//写入用户注册信息
		String insert_sql = "insert into userinfo(userName,password) values(?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(insert_sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			ConnectDB.closeConnection(con);
		}
	}
	//用户登录
	public User login(String userName, String password){
		User user = null;
		// 获取数据库连接Connection对象
		Connection con = ConnectDB.getConnection();
		// 根据用户名及密码查询用户信息
		String query_sql = "select * from userinfo where userName=? and password=? ";
		try {
			// 获取PreparedStatement对象
			PreparedStatement ps = con.prepareStatement(query_sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, userName);
			ps.setString(2, password);
			// 执行查询获取结果集
			ResultSet rs = ps.executeQuery();
			// 判断结果集是否有效
			if(rs.next()){
				// 实例化一个用户对象
				user = new User();
				// 对用户对象属性赋值
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
			// 释放此 ResultSet 对象的数据库和 JDBC 资源
			rs.close();
			// 释放此 PreparedStatement 对象的数据库和 JDBC 资源
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			ConnectDB.closeConnection(con);
		}
		return user;
	}
	//判断用户名是否存在
	public boolean userIsExist(String userName){
		// 获取数据库连接Connection对象
		Connection con = ConnectDB.getConnection();
		// 根据指定用户名查询用户信息
		String sql = "select * from userinfo where userName = '"+userName+"'";
		try {
			// 获取PreparedStatement对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 对用户对象属性赋值
			// 执行查询获取结果集
			ResultSet rs = ps.executeQuery();
			// 判断结果集是否有效
			if(!rs.next()){
				// 如果无效则证明此用户名可用
				return true;
			}
			// 释放此 ResultSet 对象的数据库和 JDBC 资源
			rs.close();
			// 释放此 PreparedStatement 对象的数据库和 JDBC 资源
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			ConnectDB.closeConnection(con);
		}
		return false; 
	}
}
