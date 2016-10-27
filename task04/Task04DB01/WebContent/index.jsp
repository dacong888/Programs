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
<style type="text/css">
html, body, div, p, form,tr, th, td {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}


table {
	border-collapse: collapse;
	border-spacing: 0;
}

a {
	text-decoration: none;
}

.txt-rt {
	text-align: right;
}
.txt-lt {
	text-align: left;
}
.txt-center {
	text-align: center;
} 
.float-rt {
	float: right;
} 
.float-lt {
	float: left;
}
.clear {
	clear: both;
} 
.pos-relative {
	position: relative;
} 
.pos-absolute {
	position: absolute;
}
.vertical-base {
	vertical-align: baseline;
} 
.vertical-top {
	vertical-align: top;
} 
nav.vertical ul li {
	display: block;
}
nav.horizontal ul li {
	display: inline-block;
} 
img {
	max-width: 100%;
}

body {
	background: url("image/bg3.png") repeat;
	font-family: 'Lato', sans-serif;
}

body a, form input[type="text"], form input[type="submit"] {
	transition: all 0.3s ease;
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
}

.wrap {
	margin: 0 auto;
	width: 80%;
}

.submit-forms {
	margin: 9em auto 0;
	text-align: center;
	width: 40%;
}

form {
	margin-top: 2em;
	padding: 8px 0px;
	background: #fff;
}

form input[type="text"] {
	background: none;
	font-style: normal;
	font-size: 15px;
	outline: none;
	padding: 13px 12px;
	border: 1px solid #EFEEEE;
	color: #CBC9C9;
	width: 68%;
	font-weight: 400;
	background: #fff;
	-webkit-appearance: none;
	margin: 0px 3px;
}

form input[type="submit"] {
	outline: none;
	font-size: 18px;
	font-weight: 400;
	padding: 13px 12px;
	cursor: pointer;
	border: none;
	color: #fff;
	margin: 0px 4px;
	width: 24%;
	background: #9a59b5;
}

form input[type="submit"]:hover, a.tem-btn:hover {
	background: #84499C;
}

/****************/
.copy-right {
	text-align: center;
	margin: 2% 0;
}

.copy-right p {
	color: #333;
	font-size: 1.1em;
	font-weight: 400;
}

.copy-right p a {
	font-size: 1em;
	color: #D02818;
}

.copy-right p a:hover {
	color: #333;
}

@media ( max-width :1440px) {
	.submit-forms {
		margin: 2em auto 0;
		text-align: center;
		width: 45%;
	}
}

@media ( max-width :1366px) {
	.submit-forms {
		margin: 2em auto 0;
		text-align: center;
		width: 50%;
	}
}

@media ( max-width :1024px) {
	.submit-forms {
		margin: 2em auto 0;
		text-align: center;
		width: 62%;
	}
	form input[type="text"]
		{
		width: 67%;
		margin: 0px 5px;
	}
}

@media ( max-width :768px) {
	.submit-forms {
		margin: 2em auto 0;
		width: 75%;
	}
	form input[type="text"]
		{
		width: 66%;
		margin: 0px 5px;
	}
}

@media ( max-width :640px) {
	.submit-forms {
		margin: 5em auto 0;
		width: 89%;
	}
}

@media ( max-width :480px) {
	.submit-forms {
		margin: 5em auto 0;
		width: 95%;
	}
	form input[type="text"]
		{
		width: 64%;
		margin: 0px 3px;
	}
	.copy-right p {
		font-size: 1.05em;
		line-height: 1.8em;
	}
}

@media ( max-width :320px) {
	form input[type="text"]
		{
		width: 57%;
		margin: 0px 1px;
		font-size: 13px;
		padding: 11px 10px;
	}
	form input[type="submit"] {
		font-size: 15px;
		padding: 11px 10px;
		margin: 0px 2px;
		width: 28%;
	}
	form{
		margin-top: 1em;
		padding: 7px 0px;
	}
	.copy-right p {
		font-size: 1em;
		line-height: 1.8em;
	}
	.submit-forms {
		margin: 3em auto 0;
		width: 95%;
	}
}

.notice {
	text-align: center;
	margin-top: 40px;
	color: #D3D3D3;
	font-size: 30px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
function checkResult(){
	var input_con = document.getElementById("input_content").value;
	if(input_con.trim().length == 0){
		//alert("请输入内容");
		return false;
	}
	
	return true;
}
</script>
</head>
<body style="text-align:center">
	<div>
		<p class="notice">诗词，中国历史上的两颗璀璨明珠！</p>
	</div>
	<div>
	<img src="image/sc.jpg" width="270" height="100" style="margin-top:100px"/>
	</div>
	<div class="submit-forms">
		<form action="DispatcherTask" method="post" onsubmit="return checkResult()">
			<input id="input_content" type="text" name="search_poet" size="30px" placeholder="请输入要搜索的诗词" /> 
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