package com.app.controller.study.quiz.quiz03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {

	/*
	 * 1. /quiz03/request1-x?item=americano&type=coffee 요청 시, 값들 출력 케이스 Console창에
	 * println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
	 */

	// 1) request 활용 (/request1-1)
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {

		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));

		return "quiz/quiz03/req";
	}

//	2) RequestParam 활용 (/request1-2)
//	3) RequestParam Map 활용 (/request1-3)
//	4) 자바 Dto 객체 활용 (/request1-4)

//	2. /quiz03/viewData1-x 요청시 화면에 값 출력
//
//	1) request 활용 /viewData1-1

	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {

		request.setAttribute("name", "싸이버거");
		request.setAttribute("type", "햄버거");

		return "quiz/quiz03/viewData";
	}

//	2) Model 활용 /viewData1-2	
	@GetMapping("/viewData1-2")
	public String viewData1_2(Model model) {

		model.addAttribute("name", "순대");
		model.addAttribute("type", "한식");

		return "quiz/quiz03/viewData";
	}

}

//	3) ModelAndView 활용 /viewData1-3
	@GetMapping("/viewData1-3")
	public ModelAndView viewData1_3(Model model) {

		ModelAndView mav = new ModelAndView();
		mav.setView("quiz/quiz03/viewData");

		mav.addObject("name", "쌀국수");
		mav.addObject("type", "베트남음식");
		// System.out.println("/quiz03/viewData");

		return mav;
	}
	
//4) Model에 객체 단위로 전달 활용 /viewData1-4

	@GetMapping("/viewData1-4")
	public String viewData1_4(Model model) {

		model.addAttribute("name", "순대");
		model.addAttribute("type", "한식");

		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setName("생수");
		drinkItem.setType("물");
		model.addAttribute("drinkItem", drinkItem);

		return "quiz/quiz03/viewData";
	}

	
//5
	
	
}

//		@GetMapping("/viewData1_2")
//		public String viewData1_2(Model model) {
//			
//			System.out.println("/viewData1_2 요청");
//			model.addAttribute("name", "달식당");
//			model.addAttribute("type", "달돈까스");
//			
//			return "quiz03/viewData1_2";
//		}
