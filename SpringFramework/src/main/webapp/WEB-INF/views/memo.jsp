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

		<div class="row-fluid">

			<div>${fn:escapeXml(user.userName)} でログイン中</div>

			<%-- ログイン失敗メッセージ --%>
			<c:if test="${resultMsg ne null && resultMsg ne ''}">
				<div class="alert alert-error fade in">
					<a class="close" data-dismiss="alert"><i class=" icon-ok"></i></a>
					<!--data dismissで消す-->
					<c:out value="${resultMsg}" />
				</div>
				<p />
			</c:if>

			<a class="brand" href="">メモ</a>

			<form:form modelAttribute="memoForm" action="memo" method="POST">
				<div>
					<form:input path="comment" placeholder="コメント" />
				</div>
				<form:button class="btn">投稿</form:button>
			</form:form>

		</div>

		<c:forEach var="item" items="${list}">
		<div class="alert alert-success">
				${fn:escapeXml(item.comment)}
				</div>
		</c:forEach>

	</div>
</body>
</html>