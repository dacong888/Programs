<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/pageStyle.css" />
</head>
<body class="dark_style">
	<form action="user!verify.action" method="post">
		<h1>登录</h1>
		
		<label> <span>姓名：</span> 
		<input type="text" name="lu.username" id="name_id" placeholder="请输入姓名" required="required" />
		</label> 
		
		<label> <span>密码：</span> 
		<input type="password" name="lu.password" id="pwd_id" placeholder="请输入密码" required="required" />
		</label>

		<s:if test="#request.loginEmpty == true">
			<p id="non_id">姓名或者密码不能为空，请重新填写。</p>
		</s:if>
		<s:elseif test="#request.noUser == true">
			<p id="non_id">不存在此用户。</p>
		</s:elseif>

		<input id="sub_id" type="submit" value="提交" />
		<a href="reg.jsp">用户注册</a>
		<a href="user!listAll.action">用户管理</a>
	</form>
</body>
</html>