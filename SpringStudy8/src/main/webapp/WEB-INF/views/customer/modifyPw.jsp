<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 변경</h2>
	
	<!-- POST 방식으로 컨트롤러에 데이터 전송 -->
	<form action="/customer/modifyPw" method="post">
		<!-- 컨트롤러의 매개변수명(newPassword)과 name 속성을 동일하게 맞춤 -->
		<label>새 비밀번호 : </label>
		<input type="password" name="newPassword" required>
		<br><br>
		
		<!-- 2) 요구사항 버튼 구성 -->
		<button type="submit">비밀번호 변경하기</button>
		<button type="button" onclick="location.href='/customer/mypage'">마이페이지</button>
	</form>
</body>
</html>