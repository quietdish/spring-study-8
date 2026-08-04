package com.app.controller.study.quiz.quiz04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz04Controller {

//	1. /quiz04/request1-x?category=100&product=4000 요청 시, 값들 출력 케이스
//		Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
//	1) request 활용 (/request1-1)
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "quiz/quiz04/req";
	}
	
//	2) RequestParam 활용 (/request1-2)
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam String category,
							@RequestParam String product) {
		
		System.out.println(category);
		System.out.println(product);
		
		return "quiz/quiz04/req";
	}
	
//	2. /quiz04/viewData1-x요청시 화면(view .jsp)에 값 출력
//	* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
//	*전달되는 값은 임의로 작성 "넘어간 값"
//
//	1) request 활용  ( /viewData1-1)
//${response001} 	${response099}	
	
	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {

		request.setAttribute("response001", "001값");
		request.setAttribute("response099", "099값");

		return "quiz/quiz04/viewData";
	
	}
}
