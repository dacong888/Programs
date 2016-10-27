<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录结果信息</title>
<style type="text/css">
#color_style{
			background: #555;
			color: #D3D3D3;
			font-weight: bold;
}

h1{
font-size:32px;
text-align:center;
}

span{
	font-size:20px;
}

</style>
</head>
<body id="color_style">
	<%request.setCharacterEncoding("UTF-8"); %>
	<h1>欢迎登录</h1>
	<ul>
		<li>
		<span>登录姓名：</span><%/*获取登录姓名 */ %>
		<%=request.getParameter("name") %>
		</li>
		<li>
		<span>登录密码：</span><%/*获取登录密码 */ %>
		<%=request.getParameter("pwd") %>
		</li>
	</ul>
</body>
</html>