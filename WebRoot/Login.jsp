<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	<script type="text/javascript">
	function login(form){
      if(form.userName.value == ""){
        alert("用户名不能为空！");
        return false;
      }
      if(form.password.value == ""){
       alert("密码不能为空！");
        return false;
       }
    }
	</script>
    
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
  <!-- 右侧登录判断控制 -->
      <div class="div3">
      <form action="LoginServlet" method="post" onSubmit="return login(this)">
           <table align="center" width="300" border="0" class="tb1">
				<tr>
					<td align="right">用户名：</td>
					<td>
						<input type="text" name="userName">
					</td>
				</tr>
				<tr>
					<td align="right">密 码：</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50">
						 <input type="submit" value="登 录">
						  <input type="reset" value="重 置">
					</td>
				</tr>
			</table>
      </form>
      </div>
  </div>
  </body>
</html>
