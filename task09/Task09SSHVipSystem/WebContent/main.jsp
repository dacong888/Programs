<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP消费查询系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/toastr.min.css" />
</head>
<body class="body-sd-color">

	<nav class="navbar navbar-sd-color navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!--导航-头-->
			<div class="navbar-header">
				<a class="navbar-brand title-brand-sd-color" href="main.jsp">VIP查询系统</a>
			</div>

			<!--导航-用户显示菜单-->
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown" aria-expanded="false">
							<i class="glyphicon glyphicon-user"></i>
							<s:iterator value="#session.UserLoginSession">
								<s:property value="userAuth.username"/>
							</s:iterator>
							  <i class="caret"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a href="login!userLogout.action" class="text-center"> <i
									class="glyphicon glyphicon-home"></i> 退出
							</a></li>
							<li class="divider"></li>
							<li><a id="aboutmessage" class="text-center btn"> <i
									class="glyphicon glyphicon-zoom-in"></i> 关于
							</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
	</nav>

	<!--侧边导航-->
	<div class="container-fluid all" style="margin-left: 220px;">
		<div class="sidebar-sd-style" style="left: 0px;">
			<ul class="nav">
				<li><a href="goodsadd.jsp"> <i
						class="glyphicon glyphicon-pencil"></i> 商品信息录入
				</a></li>
				<li><a href="goodssearch.jsp"> <i
						class="glyphicon glyphicon-search"></i> 商品信息查询
				</a></li>
				<li class="active"><a href="#vipcheck" class="nav-header"
					data-toggle="collapse"> <i class="glyphicon glyphicon-th-list"></i>
						VIP用户业务 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
				</a>
					<ul id="vipcheck" class="nav nav-list secondmenu collapse"
						style="height: 0px;">
						<li class="text-center"><a href="vipmanage.jsp"><i
								class="glyphicon glyphicon-cog"></i> VIP信息管理</a></li>
						<li class="text-center"><a href="vipreg.jsp"><i
								class="glyphicon glyphicon-pencil"></i> VIP购物登记</a></li>
						<li class="text-center"><a href="vipsearch.jsp"><i
								class="glyphicon glyphicon-zoom-in"></i> VIP信息查询</a></li>
					</ul></li>

				<li><a href="maintain.jsp"> <i
						class="glyphicon glyphicon-wrench"></i> 系统维护
				</a></li>
				<li><a href="help.jsp"> <i class="glyphicon glyphicon-edit"></i>
						帮助
				</a></li>
			</ul>
		</div>

		<!--显示内容-->
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb content-title-sd-style">
				<li class="active">首页</li>
			</ul>

			<div class="row">
				<div class="col-lg-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-pencil"> 商品信息录入 </i>
						</div>
						<div class="panel-body">
							<p class="text-sd-intent">将新进商品的信息录入保存在服务器的数据库中。</p>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-search"> 商品信息查询 </i>
						</div>
						<div class="panel-body">
							<p class="text-sd-intent">了解某种商品的详细信息。</p>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-th-list"> VIP用户业务 </i>
						</div>
						<div class="panel-body">
							<p class="text-sd-intent">VIP用户业务，主要为VIP用户的信息管理、购物登记以及信息查询。</p>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-wrench"> 系统维护 </i>
						</div>
						<div class="panel-body">
							<p class="text-sd-intent">
								增加或删除VIP用户信息。 <br />
							</p>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-edit"></i> 帮助
						</div>
						<div class="panel-body">
							<p class="text-sd-intent">使用者可以在本模块学习怎么使用系统，以方便操作。</p>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>

			</div>

			<!--我是主要内容 end-->
		</div>

	</div>


	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script src="js/common.js"></script>
</body>
</html>