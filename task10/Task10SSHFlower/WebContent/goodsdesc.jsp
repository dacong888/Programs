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
                <li><a href="goods!showGoodsDetails.action"><i class="glyphicon glyphicon-shopping-cart"></i> 我的购物车<i class="glyphicon glyphicon-chevron-right"></i></a></li>
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
			<ul class="breadcrumb" style="background-color: burlywood;">
				<li class="active"><b>类型查询结果</b></li>
				<li class="pull-right"><a href="shopping.jsp" class="btn btn-xs btn-circle btn-danger">返回首页</a></li>
			</ul>

			<!-- 内容开始 -->
			<s:if test="#request.GoodsSearchResultState.size() == 0">
				<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-danger text-center">
					<i class="glyphicon glyphicon-exclamation-sign"> 没有找到对应的商品！ </i>
				</div>
			</div>
			</s:if>
			<s:else>
				<div id="desc" class="incredible-grids">
					<s:iterator value="#request.GoodsSearchResultState" var="val" status="st" >
						<div class="col-md-3 incredible-grid">
							<p> </p>
							<img id="imgId" src= <s:property value="#val.imgUrl" /> class="img-responsive center-block"> 
							<h4 class="text-center"><s:property value="#val.goodsName" /> <s:property value="#val.price" /></h4>
							
							
								<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=<s:property value="#val.goodsName" />">
								<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
								<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
								onclick="descInfo2('<s:property value="#val.imgUrl" />','<s:property value="#val.description" />');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
						</div>
					</s:iterator>
				</div>
			</s:else>	
			<!-- 内容结束 -->
		</div>
		<ul class="breadcrumb content-nav-sd-top body-sd-color"></ul>
	</div>
	
	<!-- 商品详细信息 -->
	<div class="modal fade" id="goodsInfoModel" aria-hidden="true">
		<div class="modal-dialog dlg-sd-top">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">详细信息</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-5">
							<div>
								<img id='urlLink'
									src="img/baihe/9010811.jpg_220x240-329yuan.jpg"
									class="img-responsive">
							</div>
						</div>

						<div class="col-md-5 col-md-offset-1">
							<div>
								<h5 style="color: red;">
									<i class="glyphicon glyphicon-heart"></i> <b>花语</b>
								</h5>
								<p id="hydetailId" style="text-indent: 2em;"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary">添加</button>
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