<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 변경</h2>
	
	<form action="/customer/modifyPw2" method="post">
		
		<label>새 비밀번호 : </label>
		<input type="password" name="pw" required>
		<br><br>
		
		<button type="submit">비밀번호 변경하기</button>
		<button type="button" onclick="location.href='/customer/mypage'">마이페이지로 돌아가기</button>
	</form>
</body>
</html>