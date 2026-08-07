<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>FromB</h1>
	<p>OriginalB</p>
	<p>${fromB}
	
	<p>${sessionScope.fromA}</p>
	<p>${original}</p>
	<p>${requestScope.fromB}</p>
	<p>${sessionScope.fromB}</p>
</body>
</html>