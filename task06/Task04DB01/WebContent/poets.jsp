<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.task06struts202.pojo.PoetInfo"%>
<%@page import="java.util.LinkedList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>诗词</title>
<link href="poetStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div>
		<p
			style="margin-top: 40px; font-size: 35px; color: blue; text-align: center;">
			查询结果</p>
	</div>

	<s:if test="#request.poetInfos.size() == 0 ">
		<div>
			<p
				style="margin-top: 20px; font-size: 30px; color: red; text-align: center;">
				没有找到要查询的内容。</p>
		</div>
	</s:if>
	<s:else>
		<table class="table" style="margin-top: 2px">
			<s:if test="#request.poetSelct == '作者'">
				<tr class="alter">
					<th width="120px">诗人</th>
					<th width="600px">题目</th>
				</tr>
				<s:iterator value="#request.poetInfos">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="title" /></td>
					</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="#request.poetSelct == '题目'">
				<tr class="alter">
					<th width="100">题目</th>
					<th width="500">内容</th>
				</tr>
				<s:iterator value="#request.poetInfos">
					<tr>
						<td><s:property value="title" /></td>
						<td><s:property value="content" /></td>
					</tr>
				</s:iterator>

			</s:elseif>
			<s:elseif test="#request.poetSelct == '内容'">
				<tr class="alter">
					<th width="60px">诗人</th>
					<th width="160px">题目</th>
					<th width="400">内容</th>
				</tr>
				<s:iterator value="#request.poetInfos">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="content" /></td>
					</tr>
				</s:iterator>
			</s:elseif>
		</table>
	</s:else>
</body>
</html>

























