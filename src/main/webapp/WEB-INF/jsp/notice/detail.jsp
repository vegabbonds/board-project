<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<style type="text/css">
#notice_title {
	width: 500px;
	height: 50px;
}

#notice_content {
	width: 500px;
	height: 300px;
}
</style>
</head>

<body>

	<h1>detail</h1>
	<form action="/notice/save" method="post">
		<table>
			<c:forEach items="${detailNotice}" var="i">
				<tr>
					<td>seq</td>
					<td><input name="seq" type="text" value="${i.seq}" readonly></td>
				</tr>
				<tr>
					<td>title</td>
					<td><textarea name="title" id="notice_title">${i.title}</textarea></td>
				</tr>
				<tr>
					<td>content</td>
					<td><textarea name="content" id="notice_content">${i.content}</textarea></td>
				</tr>
				<tr>
					<td>userId</td>
					<td><input name="userId" type="text" value="${i.userId}"
						readonly></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="modify">
	</form>
</body>
</html>