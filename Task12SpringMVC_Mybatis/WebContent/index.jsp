<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body class="bg-success">
		
		<div style="margin-top: 100px;">
			<h1 class="alert-success text-center text-info">唐诗搜索</h1>
		</div>
		
		<div class="container" style="margin-top: 50px;">	
			<div class="col-lg-10 col-lg-offset-2">
				<form class="form-inline" action="retrival.html" method="post">
					<select class="form-control" name="select">
						<option>题目</option>
						<option>作者</option>
						<option>内容</option>
					</select>
					<div class="form-group input-group">
	                    <input type="text" class="form-control" style="width: 600px;" name="content" placeholder="请输入内容" required="required">
	                    <span class="input-group-btn">
	                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
	                        </button>
	                    </span>
	                </div>
				</form>
			</div>
		</div>
		
		<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	</body>
</html>