package com.app.controller.study.quiz.quiz10;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/quiz10")
public class Quiz10Controller {

	@GetMapping("/quiz10/a")
	public String a(HttpSession session) {

		session.setAttribute("fromA", "FromA");

		return "quiz/quiz10/a";
	}

	@GetMapping("/quiz10/b")
	public String b(HttpSession session, Model model) {

		session.setAttribute("fromB", "FromB");
		model.addAttribute("original", "OriginalB");
		
		return "quiz/quiz10/b";
	}
	
	
	@GetMapping("/quiz10/A2")
	public String a2(Model model, HttpSession session) {

		model.addAttribute("fromMsg", "FromA");
		model.addAttribute("orgMsg", "OriginalA");
		
		model.addAttribute("A", "A");
		
		model.addAttribute("fromB", session.getAttribute("fromB"));

		return "quiz/quiz10/ab";
	}

	@GetMapping("/quiz10/B2")
	public String b2(Model model, HttpSession session) {

		model.addAttribute("fromMsg", "FromB");
		model.addAttribute("orgMsg", "OriginalB");
		
		session.setAttribute("fromB", "FromB");
		
		return "quiz/quiz10/ab";
	}
	
	

}