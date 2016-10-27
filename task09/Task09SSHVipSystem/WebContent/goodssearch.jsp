<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品查询</title>
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
							<a class="dropdown-toggle" href="#" data-toggle = "dropdown" aria-expanded="false">
								
								<i class="glyphicon glyphicon-user"></i>
									<s:property value="#session.UserLoginSession.username"/>
								<i class="caret"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="login!userLogout.action" class="text-center">
										<i class="glyphicon glyphicon-home"></i>
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
				
			</div>
		</nav>
		
		<!--侧边导航-->
		<div class="container-fluid all" style="margin-left: 220px;">
			<div class="sidebar-sd-style" style="left: 0px;">
				<ul class="nav">
					<li>
						<a href="goodsadd.jsp">
							<i class="glyphicon glyphicon-pencil"></i>
							商品信息录入</a>
					</li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-search"></i>
							商品信息查询</a>
					</li>
					<li class="active">
						<a href="#vipcheck" class="nav-header" data-toggle="collapse">
                            <i class="glyphicon glyphicon-th-list"></i>
                            VIP用户业务
                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="vipcheck" class="nav nav-list secondmenu collapse" style="height: 0px;">
                            <li class="text-center"><a href="vipmanage.jsp"><i class="glyphicon glyphicon-cog"></i>
                            	VIP信息管理</a></li>
                            <li class="text-center"><a href="vipreg.jsp"><i class="glyphicon glyphicon-pencil"></i>
                            	VIP购物登记</a></li>
                            <li class="text-center"><a href="vipsearch.jsp"><i class="glyphicon glyphicon-zoom-in"></i>
                            	VIP信息查询</a></li>
                        </ul>
					</li>
					
					<li>
						<a href="maintain.jsp">
							<i class="glyphicon glyphicon-wrench"></i>
							系统维护</a>
					</li>
					<li>
						<a href="help.jsp">
							<i class="glyphicon glyphicon-edit"></i>
							帮助</a>
					</li>
				</ul>
			</div>
			
			<!--显示内容-->
			<div class="maincontent row">
            <!--主要内容 start-->
            <ul class="breadcrumb content-title-sd-style">
                <li class="active">商品信息查询</li>
            </ul>
            
           <!--  <div class="row" > -->
            	<form class="form-inline" action="commodity!goodsRetrival.action" method="post">
            	<div class="form-group">
            		<select class="form-control input-default margin-sd-left" name="goodsRetrival.select">
            				<option value="goods_id" id="sp_id">商品编号</option>
            				<option value="goods_name" id="sp_name">商品名称</option>
            			</select>
            		
            			<div class="form-group input-group">
	                        <input class="form-control margin-sd-width500" type="text" placeholder="请输入商品相关信息" name="goodsRetrival.content" required="required" onkeyup="checkInput(this)">
	                            <span class="input-group-btn">
	                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
	                            </button>
	            				</span>
            			</div>
            		</div>
            	</form>
           
            <div>
            
 
       
           		<ul class="breadcrumb top-sd-above20">
                	<li class="active">商品查询结果</li>
            	</ul>
            	
            	<s:if test="#request.goodsInputSpellError == false">
            		<div class="col-md-4 col-md-offset-4">
	            		<div class="alert alert-danger  text-center">
		            		<i class="glyphicon glyphicon-exclamation-sign"></i>
		            		商品输入信息类型不匹配，请重新输入。
	            		</div>
	            	</div>
            	</s:if>
            	
            	<s:if test="#request.goodsSearchState == false">
	            	<div class="col-md-4 col-md-offset-4">
	            		<div class="alert alert-danger  text-center">
		            		<i class="glyphicon glyphicon-exclamation-sign"></i>
		            		没有相关商品信息。
	            		</div>
	            	</div>
            	</s:if>
            	<s:elseif test="#request.goodsSearchState == true">
            		<table class="table table-bordered table-hover table-sd-result-style">
	            	<thead>
	            		<tr>
	            			<th class="success">商品编号</th>
	            			<th class="success">商品名称</th>
	            			<th class="success">商品价格</th>
	            			<th class="success">商品折扣</th>
	            		</tr>
	            		<s:iterator value="#request.goodsSearch">
	            		<tr>
	            			<td><s:property value="commodityId"/></td>
		            		<td><s:property value="commodityName"/></td>
		            		<td><s:property value="price"/></td>
		            		<td><s:property value="agio"/></td>
		            	</tr>
	            		</s:iterator>
	            		
	            	</thead>
            	</table>
            	</s:elseif>
            </div>		
		</div>
		</div>
		
			<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<script type="text/javascript" src="js/toastr.min.js"></script>
			<script src="js/common.js"></script>
	</body>
</html>