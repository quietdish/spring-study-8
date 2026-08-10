package com.app.controller.study.quiz.quiz12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz12")
public class Quiz12Controller {

//	경로 1) /quiz12/login
//	GET방식 접속 : ID와 PW를 입력하는 화면이 발생됨
//	POST방식 접속 : 입력한 ID와 PW를 확인하여 정상인경우로 간주하고,
//	세션에 해당 ID를 로그인한 아이디로 저장하고 /quiz12/count 페이지로 이동시킨다.
	@GetMapping("/login")
	public String login() {
		return "quiz/quiz12/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, HttpSession session) {
		
		session.setAttribute("loginId", id);
		
		return "redirect:/quiz12/count";	
	}
	
//	경로 2) /quiz12/count
//	화면에는 어떤 사용자가 로그인한 상태인지 "사용자 아이디"가 표시되며,
//	해당 사용자가 로그인한 이후, 현재 페이지에 몇번 접속했는지의 횟수가 함께 화면에 표시됨.
//	> 해당 사이트에 여러번 접속하면, 접속 할때마다 해당 count가 증가한다.
//	(로그아웃 전까지는 접속할 때 마다 count 값이 계속 증가해야한다)
//	> 만약, 로그인을 통해 어떤 사용자가 로그인 했다는 이력이 없는 경우에는 횟수는 0으로 표기.

	@GetMapping("/count")
	public String count(HttpSession session, Model model) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		if (loginId == null) {
			model.addAttribute("loginId", "로그인 안함");
			model.addAttribute("count", 0);
			
			return "quiz/quiz12/count";
		}
		
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) { //값이 없으면
			count = 1;
		} else {	//값이 있으면
			count++;	//방문 횟수 증가..
		}
		
		session.setAttribute("count", count);

		model.addAttribute("loginId", loginId);
		model.addAttribute("count", count);
		
		return "quiz/quiz12/count";
	}
	
	
//	경로 3) /quiz12/logout
//	위 경로로 접근 시, 세션에 저장되어있는 기록을 삭제하고 로그인한 이력이 없는것으로 만든다.
//	이후, /quiz12/count 페이지로 이동 시킨다
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();	// 세션 전체 속성 삭제 초기화
	
		//return "quiz/quiz12/count"; 해당 view 자원으로 연결 X
		return "redirect:/quiz12/count";	//연결할 주소
	}
	
	
}
