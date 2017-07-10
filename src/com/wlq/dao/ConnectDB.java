package com.wlq.dao;
import java.sql.*;

public class ConnectDB {
	//�������ݿ�
	public static Connection getConnection(){
		Connection con = null;
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ�����
			String dbUrl = "jdbc:mysql://localhost:3306/****";//�˴���****������Ǹ������ݿ������
			String dbUser = "root";//���ݿ��û���
			String dbPwd = "root";//���ݿ�����
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//�ر����ݿ�
	public static void  closeConnection(Connection con){
		if(con != null){
			try {
				con.close();	// �ر����ݿ�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
