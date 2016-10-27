<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP管理</title>
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
										<i class="glyphicon glyphicon-zoom-in"></i> 关于
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
						<a href="goodssearch.jsp">
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
								<a href="#"><i class="glyphicon glyphicon-cog"></i> VIP信息管理
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
						<a href="help.jsp">
							<i class="glyphicon glyphicon-edit"></i> 帮助
						</a>
					</li>
				</ul>
			</div>

			<!--显示内容-->

			<!--主要内容 start-->
			<ul class="breadcrumb content-title-sd-style">
				<li class="active">VIP信息管理</li>
			</ul>

			<div class="top-sd-above">
				<form class="form-inline" action="vip!vipManage.action" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入编号" disabled="disabled" required="required"/>
						<input type="text" class="form-control" placeholder="请输入姓名" name="vips.name" required="required" />
						<input type="number" class="form-control" placeholder="请输入年龄" name="vips.age" required="required" />
						<input type="text" class="form-control" placeholder="请输入成分" name="vips.profession" required="required" />
						<input type="date" class="form-control" placeholder="时间YYYY-MM-DD" name="vips.joinTime" required="required" />
						<input type="submit" class="btn btn-success" value="提交" />
					</div>
				</form>
			</div>
			
			<ul class="breadcrumb top-sd-above">
				<li class="active">VIP信息列表</li>
			</ul>

			<div class="panel panel-default top-sd-above">
				<div class="panel-heading">
					信息列表
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>成分</th>
									<th>入会时间</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator value="#request.VipList">
								<tr>
									<td><s:property value="vipId"/></td>
									<td><s:property value="name"/></td>
									<td><s:property value="age"/></td>
									<td><s:property value="profession"/></td>
									<td><s:property value="joinTime" /></td>
								</tr>
							</s:iterator>
								
							</tbody>
						</table>
						
						<div class="form-group input-group pull-right">
							
							<a class="btn btn-default" href="vip!vipList.action">显示VIP用户</a>
						</div>
					</div>

				</div>

			</div>
		</div>

			<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<script type="text/javascript" src="js/toastr.min.js"></script>
			<script src="js/common.js"></script>
	</body>
</html>