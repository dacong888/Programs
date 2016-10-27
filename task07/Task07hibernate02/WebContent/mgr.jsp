<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link style="text/css" href="css/infoTableStyle.css" rel="stylesheet" />
</head>
<body>
	<p align="center">用户管理页面</p>
	<div id="back_id">
		<a href="login.jsp">返回主页</a>

	</div>

	<div>
		<p align="center">用户注册信息</p>
	</div>
	<div>
		<table class="userInfo_id">
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td colspan="2">操作</td>
			</tr>

			<s:iterator value="#request.listAll" var="u">
				<tr>
					<td><s:property value="#u.id" /></td>
					<td><s:property value="#u.userName" /></td>
					<td><a
						href="user!get.action?user.id=<s:property value="#u.id"/>">查看</a></td>
					<td><a
						href="user!delete.action?user.id=<s:property value="#u.id"/>">删除</a></td>
				</tr>
			</s:iterator>

		</table>

	</div>
</body>
</html>