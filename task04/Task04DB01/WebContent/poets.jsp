<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.task04DB.dto.PoetInfo"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>123</title>
<style type="text/css">
body, table {
	font-size: 13px;
}

table {
	table-layout: fixed;
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
}

td {
	height: 30px;
}


.table {
	border: 1px solid #cad9ea;
	color: #666;
}

.table th {
	background-repeat: repeat-x;
	height: 30px;
}

.table td, .table th {
	border: 1px solid #cad9ea;
	padding: 0 1em 0;
}

.table tr.alter {
	background-color: #f5fafe;
}
</style>
</head>
<body>
	<%
		if (session.getAttribute("poetInfo") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<div>
		<p style="margin-top:40px; font-size:35px; color:blue;text-align: center;">
			查询结果
		</p>
	</div>
	<table class="table" style="margin-top: 2px">
		<tr class="alter">
			<th width="50px">诗人</th>
			<th width="160px">题目</th>
			<th width="340">内容</th>
		</tr>
		<%
			LinkedList<PoetInfo> rv = (LinkedList<PoetInfo>) session.getAttribute("poetInfo");
			if (rv == null) {
				;
			} else {
				PoetInfo p1 = rv.get(0);
		%>
		<tr>
			<%
				if (p1.getName() == null) {
			%>
			<td rowspan="<%=rv.size()%>"></td>
			<%
				} else {
			%>
			<td rowspan="<%=rv.size()%>"><%=p1.getName()%></td>
			<%
				}
			%>
			<%
				if (p1.getTitle() == null) {
			%>
			<td></td>
			<%
				} else {
			%>
			<td><%=p1.getTitle()%></td>
			<%
				}
			%>
			<%
				if (p1.getContent() == null) {
			%>
			<td></td>
			<%
				} else {
			%>
			<td><%=p1.getContent()%></td>
			<%
				}
			%>
		</tr>
		<%
			int i, j;
				i = j = rv.size();
				while ((--i) != 0) {
		%>
		<tr>

			<%
				if (p1.getTitle() == null) {
			%>
			<td></td>
			<%
				} else {
			%>
			<td><%=rv.get(j - i).getTitle()%></td>
			<%
				}
			%>
			<%
				if (p1.getContent() == null) {
			%>
			<td></td>
			<%
				} else {
			%>
			<td><%=rv.get(j - i).getContent()%></td>
			<%
				}
			%>

		</tr>

		<%
			}
		%>
		<%
			}
		%>


	</table>
	<%
		session.invalidate();
	%>
</body>
</html>