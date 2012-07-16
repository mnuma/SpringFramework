<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ログイン</title>

<!-- bootstrap -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container" style="padding-top: 40px;">

		<a class="brand" href="">ログイン</a>

		<div class="row-fluid">

			<%-- ログイン失敗メッセージ --%>
			<c:if test="${resultMsg ne null && resultMsg ne ''}">
				<c:out value="${resultMsg}" />
				<p />
			</c:if>

			<form:form modelAttribute="loginForm" action="login" method="POST">
				<div>
					<form:input path="userName" placeholder="ユーザ名" />
				</div>
				<div>
					<form:password path="userPassword" placeholder="パスワード" />
				</div>
				<form:button class="btn">ログイン</form:button>
			</form:form>

		</div>

	</div>
</body>
</html>