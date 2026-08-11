<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz13</title>
</head>

<style>
.ad-display-hide {
	display: none;
}
</style>


<body>

	<h3>hideAd</h3>

	<!--  광고영역 시작 -->
	<c:if test="${empty hideAd}">
		<form action="/quiz13/hideAd" method="post" id="adForm">
			<h2>광고</h2>
			<label><input type="checkbox" name="hide" id="chk_hide">24시간
				보지 않기</label>
			<button>닫기</button>
		</form>

		<hr>
	</c:if>

	<!--  광고영역 끝 -->

	<h3>원래 이 페이지에 표시되는 내용</h3>

	<script>
	
		const adForm = document.getElementById('adForm');
		const chkhide = document.getElementById('chk_hide');
	
		adForm.addEventListener('submit', (e)=>{
			e.preventDefault();	//기본 전송 중지
			
			//체크박스 O -> form 요청 -> 서버로 post -> 서버에서 쿠키 생성
			//체크박스 X -> 화면에서 css, js 로 자체적으로 안보이도록 처리 -> display:none; 방식
			
			if(chkhide.checked){	//check O
				adForm.submit();
			} else {	//check X
				adForm.classList.add('ad-display-hide');	
			}
			
		})
		
		
	</script>


</body>
</html>