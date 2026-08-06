package com.app.controller.study.quiz.quiz07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz07Controller {

	@GetMapping("/quiz07/listTest")
	public String listTest(@RequestParam String type,
							Model model) {
		/*
//		1. localhost:8080/quiz07/listTest?type=str 경로로 접근시
		//
//					출력 결과 ↓↓↓↓ (총 10줄)
//					스트링 리스트입니다.
		// 1) type 값에 따라 구분해서 별도의 페이지로 연결
		//str 반복 처리
		//1) view 고정 텍스트 (하드코딩)
		if(type.equals("str")) {
			
		//3) 반복 처리
		model.addAttribute("msg", "스트링 리스트입니다.!");
						
		//4)
		List<String> strList = new ArrayList<String>();
		for(int i=1; i<=5; i++) {
			strList.add("List 스트링 리스트입니다!");
		}
		model.addAttribute("strList", strList);
		
		return "quiz/quiz07/str";
			
		} else { //member
			
//		2. localhost:8080/quiz07/listTest?type=member 경로로 접근시
			List<Member> memberList = new ArrayList<Member>();
			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i)); 	//Member에 @생성자 ....
			}
			
			model.addAttribute("memberList", memberList);
			
			return "quiz/quiz07/member";
			
		} */
	

		//if(type.equals("member"))
			
		// 2) 동일한 페이지 사용 -> view 내부에서 type 값에 따라 동적으로 화면 구성
		
		model.addAttribute("type", type);
		
		// 각 type 별로 파라미터 기준으로 구분 -> 필요한 연산작업만 수행
		
		
		model.addAttribute("msg", "2스트링 리스트입니다!");
		
		/// 위 주석..
		
		List<Member> memberList = new ArrayList<Member>();
		for(int i=1; i<=5; i++) {
			memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
		}
		
		model.addAttribute("memberList", memberList);
		
		return "quiz/quiz07/listTest";
	}
}		




		//request.setAttribute("스트링", "qwe123");
		//System.out.println(request.getParameter("type"));

		
		//return "/quiz/quiz07/listTest";
		
//	@GetMapping("/quiz07/listTest")
//	public String listTest(Model model) {
//		
//		model.addAttribute("str", "스트링 리스트입니다.");
//		
//		return "/quiz/quiz07/listTest";
//	}

	
	

