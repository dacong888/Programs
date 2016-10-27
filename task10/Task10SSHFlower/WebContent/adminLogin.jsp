<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/toastr.min.css" />

</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center head-title top-sd-above100">鲜花订购系统管理员账号登录</h1>
			<div class="col-md-4 col-md-offset-4 top-sd-above20">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">登录</h3>
					</div>
					<div class="panel-body">
						<form action="login!AdminLogin.action" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" name="adminLogin.adminName"
										type="text" placeholder="请输入姓名" required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" name="adminLogin.password"
										type="password" placeholder="请输入密码" required="required" />
								</div>
								<div class="btn-group pull-right">
									<a class="btn btn-success" data-toggle="modal"
										data-target="#registerDlg">注 册</a>
								</div>

								<div class="btn-group ">

									<input type="submit" class="btn btn-default btn-success"
										value="登    录" style="position: relative; margin-right: 10px;" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-md-4 col-md-offset-4">
			
				<a class="btn btn-primary pull-right" href="index.jsp" style="width: 150px;">返回</a>
			
			<h1 class="page-header"></h1>
		</div>

		</div>

		<s:if test="#request.AdminLoginState == false">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-danger  text-center">
					<i class="glyphicon glyphicon-exclamation-sign"></i> 无效用户，请重新输入或注册。
				</div>
			</div>
		</s:if>

		<s:if test="#request.AdminLoginRegisterState == true">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 注册成功！ </i>
				</div>
			</div>
		</s:if>
		<s:elseif test="#request.AdminLoginRegisterState == false">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 两次密码输入不一致，请重新输入！ </i>
				</div>
			</div>
		</s:elseif>

	</div>


	<div class="modal fade " id="registerDlg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3 class="panel-title">注册</h3>
					</div>
					<div class="panel-body">
						<form action="login!AdminRegister.action" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="请输入姓名"
										name="adminRegister.userName" type="text" required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="请输入密码"
										name="adminRegister.password" type="password"
										required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="请确认输入"
										name="adminRegister.retryPassword" type="password"
										required="required" />
								</div>

								<div class="form-group">
									<input type="submit"
										class="btn btn-default btn-success btn-block" value="注册" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
</body>
</html>