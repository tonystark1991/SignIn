<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.wlq.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	
   
  </head>
  
  <body>
    <div class="div1" >
    <!-- 左侧导航栏 -->
      <div class="div2">
         <ul>
			<li><a href="register.jsp">用户注册</a></li>
			<li><a href="Login.jsp">用户登录</a></li>
			<li><a href="homePage.jsp">当前用户</a></li>
			<li><a href="ExitServlet">用户退出</a></li>
	     </ul>
      </div>
    <!-- 右侧主界面 -->
      <div class="div3">
      <%
      // 获取提示信息
		String info = (String)request.getAttribute("info");
		// 如果提示信息不为空，则输出提示信息
		if(info != null){
		out.println(info);
		}
        //获取用户登录信息
        User user=(User)session.getAttribute("user");
        //验证用户是否登录
        if(user != null){
       %>
      <table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
			<tr>
			  <td align="center" colspan="2">
			  <span style="font-weight: bold;font-size: 18px;"><%=user.getUsername() %></span>
			      登录成功！
			  </td>
			</tr>
      </table>
      <%								
		}else{
			out.println("<br>对不起，您还没有登录！");
		}
	  %>
      </div>
    </div>
  </body>
</html>
