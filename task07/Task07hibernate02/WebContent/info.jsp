<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<link style="text/css" href="css/infoTableStyle.css" rel="stylesheet" />
</head>
<body>
	<p align="center">用户信息页面</p>
	<div id="back_id">
		<a href="login.jsp">返回主页</a>
	</div>
	<div>
		<table class="userInfo_id">
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>密码</td>
				<td>真实姓名</td>
				<td>年龄</td>
				<td>电话</td>
				<td>地址</td>
			</tr>
			<s:iterator value="#request.userInfo">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="passWord" /></td>
					<td><s:property value="realName" /></td>
					<td><s:property value="age" /></td>
					<td><s:property value="phoneNum" /></td>
					<td><s:property value="address" /></td>
				</tr>
			</s:iterator>
		</table>

	</div>
</body>
</html>
