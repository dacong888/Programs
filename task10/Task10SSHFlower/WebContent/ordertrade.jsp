<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鲜花订购系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/toastr.min.css" />
</head>
<body class="body-sd-color">

	<nav class="navbar navbar-sd-color navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!--导航-头-->
			<div class="navbar-header">
				<a class="navbar-brand title-brand-sd-color" href="main.jsp">鲜花订购系统</a>
			</div>
			<!--管理员操作选项，通过session进行判断是否显示多余操作细节-->
			<ul class="collapse navbar-collapse nav navbar-nav top-menu navbar-right">
                <li><a href="search.jsp"><i class="glyphicon glyphicon-search"></i>商品高级查询</a></li>
                
                <li><a href="#"><i class="glyphicon glyphicon-shopping-cart"></i> 我的购物车<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          		
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
						<i class="glyphicon glyphicon-user"></i>
						<s:property value="#session.UserLoginSession.userName"/>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="login!Logout.action" class="text-center"> <i
								class="glyphicon glyphicon-home"></i> 
								退出
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a id="aboutmessage" class="text-center btn">
								<i class="glyphicon glyphicon-zoom-in"></i> 
								关于
							</a>
						</li>
					</ul>
				</li>	
            </ul>      
		</div>
	</nav>

	<!--侧边导航-->
	<div class="container-fluid col-lg-10 col-lg-offset-1" style="margin-top: 80px;">
	
		<!--显示内容-->
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb" style="background-color: burlywood;">
				<li class="active"><b>下单信息</b></li>
				
			</ul>

			<s:if test="#request.OrderTradeState == true">
				<div class="col-md-4 col-md-offset-4 top-sd-above">
					<div class="alert alert-danger text-center">
						<i class="glyphicon glyphicon-shopping-cart"> 订单下载成功，等待后台处理。 </i>
					</div>
				</div>
				<div class="col-md-4 col-md-offset-4">
					<a class="btn btn-md btn-info pull-right" href="shopping.jsp">返回首页</a>
				</div>
			</s:if>
			
		</div>
		
	</div>


	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script src="js/common.js"></script>
</body>
</html>