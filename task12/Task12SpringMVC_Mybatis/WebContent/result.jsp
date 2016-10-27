<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>查询结果</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body class="bg-success">
	<div class="container">
			<div class="col-lg-8 col-lg-offset-2">
				<h1 class="text-center" style="color: #BD362F; font-family: '黑体';">查询结果</h1>
			</div>

			<div class="col-lg-10 col-lg-offset-1">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-search"></span>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<c:choose>
									<c:when test="${requestScope.PoetsRetrivalResult.size() == 0 }">
										<h2>没有找到查询结果！</h2>
									</c:when>
									<c:otherwise>
										<table class="table table-striped table-bordered table-hover">
											<c:if test="${requestScope.select == '作者'}">
												<thead>
													<tr>
														<th>#</th>
														<th>作者</th>
														<th>题目</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="info" items="${requestScope.PoetsRetrivalResult}">	
														<c:forEach var="rv" items="${info.poetries}">
															<tr>
																<td><span class="glyphicon glyphicon-user"></span></td>
																<td>${info.name}</td>
																<td>${rv.title}</td>
															</tr>	
														</c:forEach>
													</c:forEach>
												</tbody>
											</c:if>
											<c:if test="${requestScope.select == '题目'}">
												<thead>
														<tr>
															<th>#</th>
															<th>题目</th>
															<th>内容</th>
														</tr>
												</thead>
												<tbody>
													<c:forEach var="info" items="${requestScope.PoetsRetrivalResult}">	
														<c:forEach var="rv" items="${info.poetries}">
															<tr>
																<td><span class="glyphicon glyphicon-th-list"></span></td>
																<td>${rv.title}</td>
																<td>${rv.content}</td>
															</tr>	
														</c:forEach>
													</c:forEach>
												</tbody>
											</c:if>
											<c:if test="${requestScope.select == '内容'}">
												<thead>
													<tr>
														<th>#</th>
														<th>作者</th>
														<th>题目</th>
														<th>内容</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="info" items="${requestScope.PoetsRetrivalResult}">	
														<c:forEach var="rv" items="${info.poetries}">
															<tr>
																<td><span class="glyphicon glyphicon-th-list"></span></td>
																<td>${info.name}</td>
																<td>${rv.title}</td>
																<td>${rv.content}</td>
															</tr>
														</c:forEach>
													</c:forEach>
												</tbody>
											</c:if>
										</table>
									</c:otherwise>
								</c:choose>	
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</body>
</html>