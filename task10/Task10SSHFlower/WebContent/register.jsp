<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
	</head>

	<body>
	<div class="container">
		<div class="col-sm-8 col-sm-offset-2">
			<h1 class="page-header">用户注册</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading panel-success">
						注册
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form action="login!Register.action" method="post">
									<div class="form-group">

										<input class="form-control" type="text" placeholder="请输入姓名" name="userRegister.userName" required="required"/>
									</div>
									<div class="form-group">

										<input class="form-control" type="text" placeholder="请输入真是姓名" name="userRegister.realName"/>
									</div>

									<div class="form-group">
										<input class="form-control" type="password" placeholder="请输入密码" required="required" name="userRegister.password" />
									</div>

									<div class="form-group">
										<input class="form-control" type="text" placeholder="请输入密保提示" name="userRegister.pwdQuestion"/>
									</div>

									<div class="form-group">
										<input class="form-control" type="text" placeholder="请输入密保答案" name="userRegister.pwdQuestionAnswer"/>
									</div>

									<div class="form-group">
										<input class="form-control" type="text" placeholder="请输入地址" name="userRegister.address"/>
									</div>

									<div class="form-group">
										<input class="form-control" type="number" placeholder="请输入电话" name="userRegister.phoneNO"/>
									</div>

									<div class="form-group">
										<input class="form-control" type="email" placeholder="请输入E-mail" name="userRegister.email"/>
									</div>

									<input type="submit" class="btn btn-primary" value="提交" style="width: 90px;" />
									<a type="submit" href="index.jsp" class="btn btn-primary" style="width: 90px;">取    消</a>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		
		<div class="col-md-6 col-md-offset-3">
			
				<a class="btn btn-primary pull-right" href="index.jsp" style="width: 150px;">返回</a>
			
			<h1 class="page-header"></h1>
		</div>
		
		<!-- 注册显示 -->
		
		<s:if test="#request.UserRegisterState == true">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 注册成功！ </i>
				</div>
			</div>
		</s:if>
		
</div>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	</body>

</html>