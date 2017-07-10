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
		// 获取用户名
		String userName = request.getParameter("userName");
		// 获取密码
		String password = request.getParameter("password");
		// 实例化UserDao对象
		UserDao userDao = new UserDao();
		// 根据用户密码查询用户
		User user = userDao.login(userName, password);
		// 判断user是否为空
		if (user != null) {
			// 将用户对象放入session中
			request.getSession().setAttribute("user", user);
			// 转发到homePage.jsp页面
			request.getRequestDispatcher("homePage.jsp").forward(request,
					response);
		} else {
			// 登录失败
			request.setAttribute("info", "错误：用户名或密码错误！");
			request.getRequestDispatcher("homePage.jsp").forward(request,
					response);
		}
	}

}
