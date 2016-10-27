<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/pageStyle.css" />
</head>
<body class="dark_style">
	<form action="user!add.action" method="post">
		<h1>注册</h1>

		<label> <span>姓名：</span> <input type="text"
			name="user.userName" id="name_id" placeholder="请输入姓名" required="required" /> <s:if
				test="#request.userNameEmpty == true">
			请输入姓名！
		</s:if>
		</label> <label> <span>密码：</span> <input type="password"
			name="user.passWord" id="pwd_id" placeholder="请输入密码" required="required" /> <s:if
				test="#request.pwdEmpty == true">
			请输入密码！
		</s:if>
		</label> <label> <span>真实姓名：</span> <input type="text"
			name="user.realName" id="rn_id" placeholder="请输入真实姓名" required="required" /> <s:if
				test="#request.rnEmpty == true">
			请输入真实姓名！
		</s:if>
		</label> <label> <span>年龄：</span> <input type="text" name="user.age"
			id="age_id" placeholder="请输入年龄" required="required" /> <s:if
				test="#request.ageEmpty == true">
			请输入年龄！
		</s:if>
		</label> <label> <span>电话：</span> <input type="text"
			name="user.phoneNum" id="phn_id" placeholder="请输入电话" required="required" /> <s:if
				test="#request.phoneNumEmpty == true">
			请输入电话！
		</s:if>
		</label> <label> <span>地址：</span> <input type="text"
			name="user.address" id="addr_id" placeholder="请输入地址" required="required" /> <s:if
				test="#request.addrEmpty == true">
			请输入地址！
		</s:if>
		</label> <label> <span>&nbsp;</span> <input id="reg_id" type="submit"
			value="注册" />
		</label>
	</form>
</body>
</html>