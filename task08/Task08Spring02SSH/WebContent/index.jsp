<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>诗词</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Flat Buttons Submit Forms,Button hover effects,Tool tips, ancher link hover effects,Elements" />
<link href="indexStyle.css" rel="stylesheet" type="text/css"/>

</head>
<body style="text-align:center">
	<div>
		<p class="notice">诗词，中国历史上的两颗璀璨明珠！</p>
	</div>
	<div>
	<img src="image/sc.jpg" width="270" height="100" style="margin-top:100px"/>
	</div>
	<div class="submit-forms">
		<form action="retrieval.action" method="post">
			<select name="select" class="styled-select">
				<option>作者</option>
				<option>题目</option>
				<option>内容</option>
			</select>
			<input id="input_content" type="text" autofocus="autofocus" name="content" size="30px" placeholder="请输入要搜索的诗词" required="required" />
			<input type="submit"value="搜索" />
		</form>
	</div>
 
	<div class="copy-right">
		<div class="wrap">
			<p style="margin-top:200px">Copyright &copy; 2016 All rights Reserved</p>
		</div>
	</div>
</body>
</html>