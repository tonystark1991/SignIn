package com.wlq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wlq.User;
import com.wlq.dao.UserDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		// ��ȡ�û���
		String userName = request.getParameter("userName");
		// ��ȡ����
		String password = request.getParameter("password");
		// ʵ����UserDao����
		UserDao userDao = new UserDao();
		// �����û������ѯ�û�
		User user = userDao.login(userName, password);
		// �ж�user�Ƿ�Ϊ��
		if (user != null) {
			// ���û��������session��
			request.getSession().setAttribute("user", user);
			// ת����homePage.jspҳ��
			request.getRequestDispatcher("homePage.jsp").forward(request,
					response);
		} else {
			// ��¼ʧ��
			request.setAttribute("info", "�����û������������");
			request.getRequestDispatcher("homePage.jsp").forward(request,
					response);
		}
	}

}
