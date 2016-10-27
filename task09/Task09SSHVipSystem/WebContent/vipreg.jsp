<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP注册</title>
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
								<s:property value="#session.UserLoginSession.username"/>
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
						<li class="text-center"><a href="#"><i
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
			
			<ul class="breadcrumb content-title-sd-style">
				<li class="active">VIP购物登记</li>
			</ul>

			<div class="row content-title-sd-style">
				<div class="col-lg-8 col-lg-offset-2">
					<form action="vip!vipGoodsRegister.action" method="post">
            			<div class="form-group input-group">
            				<span class="input-group-addon">
            					<i class="glyphicon glyphicon-qrcode"></i>
            				</span>
            				<input class="form-control" placeholder="VIP编号" type="number" name="vipConsume.vipId" required="required"  onkeyup="checkNum(this)"/>
            			</div>
            			<div class="form-group input-group">
            				<span class="input-group-addon">
            					<i class="glyphicon glyphicon-user"></i>
            				</span>
            				<input class="form-control" placeholder="VIP姓名" type="text" name="vipConsume.vipName" required="required" />
            			</div>
            			<div class="form-group input-group">
            				<span class="input-group-addon">
            					<i class="glyphicon glyphicon-barcode"></i>
            				</span>
            				<input class="form-control" placeholder="商品编号" type="number" name="vipConsume.goodsId" required="required"  onkeyup="checkNum(this)"/>
            			</div>
            			<div class="form-group input-group">
            				<span class="input-group-addon">
            					<i class="glyphicon glyphicon-tags"></i>
            				</span>
            				<input class="form-control" placeholder="商品名称" type="text" name="vipConsume.goodsName" required="required"/>
            			</div>
            			<div class="form-group input-group">
            				<span class="input-group-addon">
            					<i class="glyphicon glyphicon-usd"></i>
            				</span>
            				<input class="form-control" placeholder="商品价格" type="text" name="vipConsume.goodsPrice" required="required" onkeyup="checkNum(this)"/>
            			</div>
            			
            			<div class="form-group input-group pull-right">
            				<input type="submit" class="btn btn-default btn-success" value="提 交" />
            			</div>
            		</form>
				</div>

			</div>

			<ul class="breadcrumb content-title-sd-style">
				<li class="active">VIP登记结果</li>
			</ul>
			<s:if test="#request.VipConsumeState == 1">
				<div class="col-md-4 col-md-offset-4">
            		<div class="alert alert-success  text-center">
            		<i class="glyphicon glyphicon-ok"></i>
            		vip用户不存在。</div>
            	</div>
			</s:if>
			<s:elseif test="#request.VipConsumeState == 2">
				<div class="col-md-4 col-md-offset-4">
					<div class="alert alert-success  text-center">
						<i class="glyphicon glyphicon-ok"></i>
						商品不存在。
					</div>
				</div>
			</s:elseif>
			<s:elseif test="#request.VipConsumeState == 3">
				<div class="col-md-4 col-md-offset-4">
					<div class="alert alert-success  text-center">
						<i class="glyphicon glyphicon-ok"></i>
						操作成功。
					</div>
				</div>
			</s:elseif>
				
		</div>

	</div>


	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script src="js/common.js"></script>
</body>
</html>