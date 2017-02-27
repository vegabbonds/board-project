<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
</head>
<body>
	<h1>list</h1>
	<table>
		<tr>
			<th>seq</th>
			<th>title</th>
			<th>userId</th>
		</tr>
		<c:forEach items="${noticeList}" var="i">
			<tr>
				<td>${i.seq}</td>
				<td><a href="#none" onClick="detail(this)">${i.title}</a></td>
				<td>${i.userId}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="/notice/form" id="add_notice">
		<input type="submit" value="추가">
	</form>

	<form action="/notice/{sequence}" id="detail_view">
		<input type="hidden" id="sequence" name="sequence" value="">
	</form>

</body>
<script>
	function detail(some) {
		var sequence = $(some).parent().parent().find("td:eq(0)").html();
		$("#sequence").val(sequence);
		$("#detail_view").submit();
	}
</script>
</html>