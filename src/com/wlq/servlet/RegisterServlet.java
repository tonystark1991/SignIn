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
		// 获取用户名
		String userName = request.getParameter("userName");
		// 获取密码
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		if(userName != null && !userName.isEmpty()){
			if(userDao.userIsExist(userName)){
				// 实例化一个User对象
				User user = new User();		
				// 对用户对象中的属性赋值
				user.setUsername(userName);	
				user.setPassword(password);
				userDao.saveUser(user);	
				request.setAttribute("info", "恭喜，注册成功！<br>");
			}else{
				request.setAttribute("info", "错误：此用户名已存在！");
			}
		}
		// 转发到homePage.jsp页面
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
	}
	

}
