package com.wlq.dao;
import java.sql.*;

import com.wlq.dao.ConnectDB;
import com.wlq.User;
public class UserDao {
	//����û����û�ע��
	public void saveUser(User user){
		Connection con=ConnectDB.getConnection();
		//д���û�ע����Ϣ
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
			// �ر����ݿ�����
			ConnectDB.closeConnection(con);
		}
	}
	//�û���¼
	public User login(String userName, String password){
		User user = null;
		// ��ȡ���ݿ�����Connection����
		Connection con = ConnectDB.getConnection();
		// �����û����������ѯ�û���Ϣ
		String query_sql = "select * from userinfo where userName=? and password=? ";
		try {
			// ��ȡPreparedStatement����
			PreparedStatement ps = con.prepareStatement(query_sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, userName);
			ps.setString(2, password);
			// ִ�в�ѯ��ȡ�����
			ResultSet rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(rs.next()){
				// ʵ����һ���û�����
				user = new User();
				// ���û��������Ը�ֵ
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
			// �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ
			rs.close();
			// �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// �ر����ݿ�����
			ConnectDB.closeConnection(con);
		}
		return user;
	}
	//�ж��û����Ƿ����
	public boolean userIsExist(String userName){
		// ��ȡ���ݿ�����Connection����
		Connection con = ConnectDB.getConnection();
		// ����ָ���û�����ѯ�û���Ϣ
		String sql = "select * from userinfo where userName = '"+userName+"'";
		try {
			// ��ȡPreparedStatement����
			PreparedStatement ps = con.prepareStatement(sql);
			// ���û��������Ը�ֵ
			// ִ�в�ѯ��ȡ�����
			ResultSet rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(!rs.next()){
				// �����Ч��֤�����û�������
				return true;
			}
			// �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ
			rs.close();
			// �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// �ر����ݿ�����
			ConnectDB.closeConnection(con);
		}
		return false; 
	}
}
