<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> quiz12 count page </h1>
	
	<p>로그인한 사용자 : ${loginId}</p>
	<p>접속 횟수 : ${count}</p>
	
	<br><br>
	<a href="/quiz12/login">로그인</a>
	
	<br><br>
	<a href="/quiz12/logout">로그아웃</a>
	
</body>
</html>