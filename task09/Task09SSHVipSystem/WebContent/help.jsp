<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助信息</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/toastr.min.css" />
</head>
<body>


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
						<li class="dropdown">
							<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
								<i class="glyphicon glyphicon-user"></i> 
									<s:property value="#session.UserLoginSession.username"/>
								<i class="caret"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="login!userLogout.action" class="text-center">
										<i class="glyphicon glyphicon-home"></i> 退出
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
			</div>
		</nav>

		<!--侧边导航-->
		<div class="container-fluid all" style="margin-left: 220px;">
			<div class="sidebar-sd-style" style="left: 0px;">
				<ul class="nav">
					<li>
						<a href="goodsadd.jsp">
							<i class="glyphicon glyphicon-pencil"></i> 商品信息录入
						</a>
					</li>
					<li>
						<a href="goodssearch.html">
							<i class="glyphicon glyphicon-search"></i> 商品信息查询
						</a>
					</li>
					<li class="active">
						<a href="#vipcheck" class="nav-header" data-toggle="collapse">
							<i class="glyphicon glyphicon-th-list"></i> VIP用户业务
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="vipcheck" class="nav nav-list secondmenu collapse" style="height: 0px;">
							<li class="text-center">
								<a href="vipmanage.jsp"><i class="glyphicon glyphicon-cog"></i> VIP信息管理
								</a>
							</li>
							<li class="text-center">
								<a href="vipreg.jsp"><i class="glyphicon glyphicon-pencil"></i> VIP购物登记
								</a>
							</li>
							<li class="text-center">
								<a href="vipsearch.jsp"><i class="glyphicon glyphicon-zoom-in"></i> VIP信息查询
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="maintain.jsp">
							<i class="glyphicon glyphicon-wrench"></i> 系统维护
						</a>
					</li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-edit"></i> 帮助
						</a>
					</li>
				</ul>
			</div>

			<!--显示内容-->
			<div class="maincontent row">
				<!--我是主要内容 start-->
				<ul class="breadcrumb content-title-sd-style">
					<li class="active">帮助</li>
				</ul>

				<div class="col-sm-12">
					<div class="jumbotron">
						<p>
							<strong>VIP查询系统的主要功能：</strong>
						</p>
						<p><strong>◆ 登录</strong></p>
						<p class="text-sd-intent">
							本系统为商场VIP消费情况查询系统，具有一定的保密性。因此必须要有一定的权限 才能使用本系统查询。要进行查询就必须先登录才能使用本系统。登录之后进入系统的主 界面，在主界面可以选择用户想要执行的功能模块。
						</p>
						<p><strong>◆ 商品信息录入</strong></p>
						<p class="text-sd-intent">
							在维护本系统时，要不断更新系统的数据。其中商品的信息是在不断增加的，当新进 商品时，要保证商品信息的同步更新。在本模块可将新进商品的信息录入保存在服务器的 数据库中。
						</p>
						<p><strong>◆ 商品信息查询</strong></p>
						<p class="text-sd-intent">

							有时候想了解某种商品的详细信息。在本模块可以查询所想知道的商品的详细信息。
						</p>
						<p><strong>◆ VIP信息管理</strong></p>

						<p class="text-sd-intent">

							本系统为VIP消费查询系统，因此对VIP的信息管理是核心。本模块是进行VIP信息登 记的模块。
						</p>
						<p><strong>◆ VIP信息管理</strong></p>

						<p class="text-sd-intent">

							本系统为VIP消费查询系统，因此对VIP的信息管理是核心。本模块是进行VIP信息登 记的模块。
						</p>
						<p><strong>◆ VIP购物登记</strong></p>

						<p class="text-sd-intent">

							当VIP购物时，要对其所购物品进行登记，以便以后对其进行统计。
						</p>
						<p><strong>◆ VIP信息查询</strong></p>

						<p class="text-sd-intent">

							对VIP的信息查询是经常性的操作，在本模块可以查询指定VIP的详细信息，以了解某 会员的购物情况。
						</p>
						<p><strong>◆ 系统维护</strong></p>

						<p class="text-sd-intent">

							本系统并不是每个人都可以使用，在本模块可以授予某个使用者使用本系统的权利， 同样也可以剥夺某个使用者使用本系统的权利。
						</p>
						<p><strong>◆ 帮助</strong></p>

						<p class="text-sd-intent">

							使用者可以在本模块学习怎么使用系统，以方便操作。
						</p>

					</div>
				</div>

			</div>

		</div>

			<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<script type="text/javascript" src="js/toastr.min.js"></script>
			<script src="js/common.js"></script>
	</body>


</body>
</html>