package com.wlq.dao;
import java.sql.*;

public class ConnectDB {
	//连接数据库
	public static Connection getConnection(){
		Connection con = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接
			String dbUrl = "jdbc:mysql://localhost:3306/****";//此处的****代表的是个人数据库的名称
			String dbUser = "root";//数据库用户名
			String dbPwd = "root";//数据库密码
			// 获取数据库连接
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//关闭数据库
	public static void  closeConnection(Connection con){
		if(con != null){
			try {
				con.close();	// 关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
