<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>メモ</title>

<!-- bootstrap -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container" style="padding-top: 40px;">

		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="memo">共有しないっ!!</a>
					<ul class="nav">
						<li class="active"><a href="">TOP</a></li>
					</ul>

					<form:form modelAttribute="searchForm" action="search" method="GET" class="navbar-search pull-right">
							<form:input path="searchQuery" class="search-query" placeholder="検索" />
						<form:button class="btn">検索</form:button>
					</form:form>

					<!--ドロップダウンメニュー-->
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <span>
									${fn:escapeXml(user.userName)} でログイン中 </span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="login">ログアウト</a></li>
							</ul></li>
					</ul>

				</div>
			</div>
		</div>


		<div class="row-fluid" style="padding-top: 40px;">

			<a class="brand" href="">検索結果</a>

		</div>

		<c:forEach var="item" items="${result}">
			<font color="#C4C4C4"> ${fn:escapeXml(item.timestamp)} </font>
			<div class="alert alert-success">
				${fn:escapeXml(item.comment)} 
			</div>
		</c:forEach>

	</div>
</body>
</html>