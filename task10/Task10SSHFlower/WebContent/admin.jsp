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
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
						<i class="glyphicon glyphicon-user"></i>
						<s:property value="#session.AdminLoginSession.adminName"/>
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
			<div>
				<ul class="breadcrumb" style="background-color: burlywood;">
					<li class="active"><b>用户管理</b></li>
				</ul>
				
				<!-- 用户管理 -->
				<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>名称</th>
									<th>密码</th>
									<th>地址</th>
									<th>电话</th>
									<th>邮箱</th>
									<td>操作</td>
								</tr>
							</thead>
							
							<tbody>
							<s:if test="#request.UserNullState == true">
								<div class="col-md-4 col-md-offset-4">
									<div class="alert alert-danger text-center">
										<i class="glyphicon glyphicon-cog"> 没有选购任何商品。 </i>
									</div>
								</div>
							</s:if>
							<s:else>
								<s:iterator value="#request.UserState" var="u">
									<tr>
										<td><s:property value="#u.id" /></td>
										<td><s:property value="#u.userName" /></td>
										<td><s:property value="#u.passWord" /></td>
										<td><s:property value="#u.address" /></td>
										<td><s:property value="#u.phoneNO" /></td>
										<td><s:property value="#u.email" /></td>
										<td><a class="btn btn-danger btn-xs" href="admin!deleteUser.action?adminOptr.id=<s:property value="#u.id" />">删除</a></td>
									</tr>
								</s:iterator>
							</s:else>
							</tbody>
						</table>
						<div class="form-group input-group pull-right">
							<a class="btn btn-info" href="admin!listUser.action">用户管理</a>
						</div>				
					</div>
			</div>
			
			<div>
				<ul class="breadcrumb" style="background-color: burlywood;">
					<li class="active"><b>订单管理</b></li>
				</ul>
				
				<!-- 订单管理 -->
				<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>价格</th>
									<th>总和</th>
									<th>用户名称</th>
									<th>创建时间</th>
									<td>操作</td>
								</tr>
							</thead>
							
							<tbody>
							
							<s:if test="#request.OrderNullState == true">
								<div class="col-md-4 col-md-offset-4">
									<div class="alert alert-danger text-center">
										<i class="glyphicon glyphicon-cog"> 没有选购任何商品。 </i>
									</div>
								</div>
							</s:if>
							<s:else>
								<s:iterator value="#request.OrderState" var="u">
									<tr>
										<td><s:property value="#u.ordersId" /></td>
										<td><s:property value="#u.sum" /></td>
										<td><s:property value="#u.num" /></td>
										<td><s:property value="#u.userName" /></td>
										<td><s:property value="#u.createTime" /></td>
										<td><a class="btn btn-danger btn-xs" href="admin!deleteOrder.action?adminOptr.id=<s:property value="#u.ordersId" />">删除</a></td>
									</tr>
								</s:iterator>
							</s:else>
							
							</tbody>
						
						</table>
						<div class="form-group input-group pull-right">
							<a class="btn btn-info" href="admin!listOrder.action">订单管理</a>
						</div>				
					</div>														
				</div>
			
			<div>
				<ul class="breadcrumb" style="background-color: burlywood;">
					<li class="active"><b>商品管理</b></li>
				</ul>
				
				<!-- 用户管理 -->
				<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>名称</th>
									<th>价格</th>
									<th>类别</th>
									<td>操作</td>
								</tr>
							</thead>
							
							<tbody>
							<s:if test="#request.GoodsNullState == true">
								<div class="col-md-4 col-md-offset-4">
									<div class="alert alert-danger text-center">
										<i class="glyphicon glyphicon-cog"> 没有选购任何商品。 </i>
									</div>
								</div>
							</s:if>
							<s:else>
								<s:iterator value="#request.GoodsState" var="g">
									
									<s:iterator value="#g.goods" var="u" >
										<tr>
											<td><s:property value="#u.id" /></td>
											<td><s:property value="#u.goodsName" /></td>
											<td><s:property value="#u.price" /></td>
											<td><s:property value="#g.categoryName" /></td>
											<td><a class="btn btn-danger btn-xs" href="admin!deleteGoods.action?adminOptr.id=<s:property value="#u.id" />">删除</a></td>
										</tr>
									</s:iterator>
									
								</s:iterator>
							</s:else>
							</tbody>
						
						</table>
						<div class="form-group input-group pull-right">
							<a class="btn btn-info" href="admin!listGoods.action">商品管理</a>
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