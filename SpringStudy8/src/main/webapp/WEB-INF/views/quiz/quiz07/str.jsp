<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>str</h1>
	
	<!-- 고정된 하드코딩 2줄만 하자 ㅋ -->
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>2줄만~</p>
	
	<!-- 모델 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${msg}</p>
	</c:forEach>
	
	<!-- 넘어온 list를 그대로 반복 출력 -->
	<c:forEach var="str" items="${strList}">
		<p>${str}</p>
	</c:forEach>
	
</body>
</html>