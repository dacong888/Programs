<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>鲜花订购</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">	
		<link rel="stylesheet" href="css/templatemo-style.css">
		<link rel="stylesheet" href="css/common.css">

	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<section class="tm-section-intro">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<div class="tm-wrapper-center">
							<h1 class="tm-section-intro-title">鲜花驿站</h1>
							<div>
								<button class="btn btn-primary" data-toggle="modal" data-target="#login">登录</button>
								<a class="btn btn-success" href="register.jsp">注册</a>
							</div>
							
							<div>
								<a href="adminLogin.jsp">管理员登录</a>
							</div>	
							
							<s:if test="#request.UserLoginState == false">
								<div class="alert alert-success text-center">
									<i class="glyphicon glyphicon-exclamation-sign"> 用户不存在，请重新输入！ </i>
								</div>
							</s:if>	
						</div>
					</div>	
				</section>
				
			</div>
			

			<div class="row">
				<div class="col-12">
					<p class="text-center" style="margin-top: 50px;">Copyright &copy; 2016.
						<a href="">鲜花订购网</a> 
					</p>
				</div>
			</div>
		</div>
		
		
		<!-- 登录框 -->
		
            
            <div class="modal fade " id="login" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h3 class="panel-title">登录</h3>
							</div>
							<div class="panel-body">
								<form action="login!Login.action" method="post">
									<fieldset>
										<div class="form-group">
											<input class="form-sd-control" placeholder="请输入姓名"
												name="userLogin.userName" type="text" required="required" />
										</div>
		
										<div class="form-group">
											<input class="form-sd-control" placeholder="请输入密码"
												name="userLogin.password" type="password"
												required="required" />
										</div>
										<div class="form-group">
											<input type="submit"
												class="btn btn-default btn-success btn-block" value="登录" />
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
            
		<script src="js/jquery-3.1.0.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.touchSwipe.min.js"></script>
	</body>
</html>