package com.app.controller.study.quiz.quiz14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz14Controller {

	@Autowired
	CupBean cupBean;
	
	@Autowired
	PlateBean plateBean;
	
	@GetMapping("/quiz14/fullOrder")
	public String fullOrder() {

		System.out.println(cupBean.getCoffeeBean().getName());
		System.out.println(plateBean.getDessertBean().getName());

		return "quiz/quiz14/order";
	}
	
	
	@GetMapping("/quiz14/orderCoffee")
	public String orderCoffee() {

		System.out.println(cupBean.getCoffeeBean().getName());

		return "quiz/quiz14/order";
	}
	
	
	@GetMapping("/quiz14/orderDessert")
	public String orderDessert() {

		System.out.println(plateBean.getDessertBean().getName());

		return "quiz/quiz14/order";
	}
	
//	localhost:8080/quiz14/fullOrder 로 접속시 리스트 출력. (음료와 디저트 둘다 출력)
//	localhost:8080/quiz14/orderCoffee 로 접속시 민트초코프라페 출력
//	localhost:8080/quiz14/orderDessert 로 접속시 당근케이크 출력
	
	
}
