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
			<h1 class="text-center head-title top-sd-above100">VIP查询系统</h1>
			<div class="col-md-4 col-md-offset-4 top-sd-above20">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">登录</h3>
					</div>
					<div class="panel-body">
						<form action="login!userLogin.action" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" name="userAuth.username"
										type="text" placeholder="请输入姓名" required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" name="userAuth.password"
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

		</div>

		<s:if test="#request.UserLoginState == false">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-danger  text-center">
					<i class="glyphicon glyphicon-exclamation-sign"></i> 无效用户，请重新输入或注册。
				</div>
			</div>
		</s:if>

		<s:if test="#request.UserLoginRegisterState == true">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 注册成功！ </i>
				</div>
			</div>
		</s:if>
		<s:elseif test="#request.UserLoginRegisterState == false">
			<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 两次密码输入不一致，请重新输入！ </i>
				</div>
			</div>
		</s:elseif>

		<div class="row top-sd-above300">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-danger">
					<div class="panel-heading">提示信息</div>
					<div class="panel-body">
						<div class="alert-success">
							VIP消费查询系统分为普通账户和管理员账户。 两者在系统的试用权限上有所不同。例如，数据库表中 注册管理员账户时，需要设定管理员<strong><em>用户权限为1</em></strong>，其他<strong><em>用户权限为0</em></strong>。
						</div>
					</div>
				</div>
			</div>
		</div>
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
						<form action="login!userRegister.action" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="请输入姓名"
										name="loginRegister.userName" type="text" required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="请输入密码"
										name="loginRegister.password" type="password"
										required="required" />
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="请确认输入"
										name="loginRegister.retryPassword" type="password"
										required="required" />
								</div>

								<div class="form-group">
									<label class="radio-inline"> <input
										name="loginRegister.privilage" value="1" checked="checked"
										type="radio">管理员
									</label> <label class="radio-inline"> <input
										name="loginRegister.privilage" value="0" type="radio">普通用户
									</label>
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