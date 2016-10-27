<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
	<style>
		.center-align{
			display: block;
			margin-left: auto;
			margin-right: auto;
		}

	</style>
</head>
<body>
		<h1 style="text-align: center;">SpringMVC登录测试</h1>
		<p  style="text-align: center; color:red"><b>测试登录：用户名：admin；密码：123</b></p>
		<form action="login.html" method="post">
			<input class="center-align" type="text" name="username" placeholder="请输入姓名" required="required" /><br>
			<input class="center-align" type="password" name="password" placeholder="请输入密码"  required="required" /><br>
			<input  class="center-align" type="submit" value="提交"  />
		</form>
	</body>
</html>