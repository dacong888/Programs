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
                <li><a href="#"><i class="glyphicon glyphicon-search"></i>商品高级查询</a></li>              
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
			<!--我是主要内容 start-->
			<ul class="breadcrumb" style="background-color: burlywood;">
				<li class="active"><b>精准查询结果</b></li>
				<li class="pull-right"><a href="shopping.jsp" class="btn btn-xs btn-circle btn-danger">返回首页</a></li>
			</ul>

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="glyphicon glyphicon-pencil">商品高级查询 </i>
						</div>
						<div class="panel-body">
						
						<table class="table table-hover">
						
						<tbody>
							<tr>
								<td>
								<div class="form-group">
									<form class="form-inline" action="goods!goodsNameSearch.action" method="post">
				                        <input class="form-control " type="text" placeholder="请输入商品名称" name="goodsNameRetrival.name" required="required" onkeyup="checkInput(this)">
				                        <div class="form-group input-group content-nav-sd-top pull-right">
		                                	<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i>按名称搜索</button>
			            				</div>
			            			</form>
			            		</div>
								
								</td>			
								<td>
							</tr>
							
							<tr>
								<td>
									<div>
									<form class="form-inline" action="goods!goodsPriceSearch.action" method="post">
					            		<select class="form-control" name="goodsPriceRetrival.select">
					            				<option value="goods_100" id="sp_100">100-200</option>
					            				<option value="goods_200" id="sp_200">200-300</option>
					            				<option value="goods_300" id="sp_300">300以上</option>
					            		</select>
					            		 
				                       <div class="form-group input-group content-nav-sd-top pull-right">
		                                	<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i>按价格搜索</button>
			            				</div>
					            	</form>			
						            </div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div >
										<form class="form-inline" action="goods!goodsTypeSearch.action" method="post">
						            		<select class="form-control"  name="goodsTypeRetrival.select">
												<option value="goods_bh" id="sp_bh">百合</option>
					            				<option value="goods_knx" id="sp_knx">康乃馨</option>
					            				<option value="goods_mtl" id="sp_mtl">马蹄莲</option>
					            				<option value="goods_mg" id="sp_mg">玫瑰</option>
					            				<option value="goods_xrk" id="sp_xrk">向日葵</option>
					            				<option value="goods_yjx" id="sp_yjx">郁金香</option>
						            		</select>
						            		<div class="form-group input-group content-nav-sd-top pull-right">
			                                	<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i>按类型搜索</button>
				            				</div>
			            				</form>
					            	</div>
								</td>
							</tr>
						</tbody>
					
					</table>
							
						</div>
						<div class="panel-footer"></div>
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