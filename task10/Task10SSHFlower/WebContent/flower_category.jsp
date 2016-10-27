<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                
          		<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
							<i class="glyphicon glyphicon-user"></i>
							<s:iterator value="#session.UserLoginSession">
								<s:property value="userAuth.username"/>
							</s:iterator>
							  <i class="caret"></i>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="login!userLogout.action" class="text-center"> <i
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
            </ul>
            
		</div>
	</nav>

	<!--侧边导航-->
	<div class="container-fluid col-lg-10 col-lg-offset-1" style="margin-top: 80px;">
	
		<!--显示内容-->
		<div class="maincontent row">
			
			<ul class="breadcrumb content-title-sd-style">
				<li class="active">管理员操作</li>
			</ul>

			<div class="row">
				<div class="col-md-3 col-md-offset-1">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-pencil">用户管理</i>
						</div>
						<div class="panel-body">
							<a class="text-center" href="#">用户管理</a>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
			
				<div class="col-md-3 col-md-offset-1">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-pencil">订单管理</i>
						</div>
						<div class="panel-body">
							<a class="text-center" href="#">订单管理管理</a>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
			
				<div class="col-md-3 col-md-offset-1">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-pencil">商品管理</i>
						</div>
						<div class="panel-body">
							<a class="text-center" href="#">商品管理</a>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
		</div>
		
		<ul class="breadcrumb">
			<li class="active">操作</li>
		</ul>

	</div>


	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script src="js/common.js"></script>
</body>
</html>