<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
	<h1>Notice 추가</h1>

	<form action="/notice/save" method="post">
		<input type="text" id="title" name="title" placeholder="title"
			required /> <input type="text" id="content" name="content"
			placeholder="content" required /><input type="submit" value="추가" />
	</form>

</body>
</html>