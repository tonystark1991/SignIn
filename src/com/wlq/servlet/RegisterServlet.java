package com.wlq.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wlq.User;
import com.wlq.dao.UserDao;
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�û���
		String userName = request.getParameter("userName");
		// ��ȡ����
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		if(userName != null && !userName.isEmpty()){
			if(userDao.userIsExist(userName)){
				// ʵ����һ��User����
				User user = new User();		
				// ���û������е����Ը�ֵ
				user.setUsername(userName);	
				user.setPassword(password);
				userDao.saveUser(user);	
				request.setAttribute("info", "��ϲ��ע��ɹ���<br>");
			}else{
				request.setAttribute("info", "���󣺴��û����Ѵ��ڣ�");
			}
		}
		// ת����homePage.jspҳ��
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
	}
	

}
