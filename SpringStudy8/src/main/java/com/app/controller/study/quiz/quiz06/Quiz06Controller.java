package com.app.controller.study.quiz.quiz06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("quiz06")
public class Quiz06Controller {

	@GetMapping("/ask-bmi")
	public String askBmi() {
		return "quiz/quiz06/ask-bmi";
	}
	
	@GetMapping("/result-bmi")
	public String resultBmi(
		@RequestParam String name,
		@RequestParam double height,
        @RequestParam double weight,        
		Model model) {
		
		height = height / 100.0;

	    double bmi = weight / (height * height);
	    
		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", bmi);
	
	    return "quiz/quiz06/result-bmi";
	}
	
	
}
