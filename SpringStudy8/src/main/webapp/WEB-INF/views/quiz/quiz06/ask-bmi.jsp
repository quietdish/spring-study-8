<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BMI 계산 페이지</h1>
	<form action="result-bmi" method="get">
		이름 : <input type="text" name="name"><br>
		키 : <input type="text" name="height"><br>
		몸무게 : <input type="text" name="weight"><br>
		<input type="submit" value="확인">
	</form>
	
</body>
</html>