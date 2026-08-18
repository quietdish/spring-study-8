package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.commonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

@Controller
public class CustomerController {

	// 일반 고객 사용자가 접근하는 관련 서비스

	@Autowired
	UserService userService;
	// 사용자 계정정보 관련 서비스 로직

	@GetMapping("/customer/signup")
	public String signupPage() {
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String signup(User user) {

		// user.setUserType("CUS");

		int result = userService.saveCustomerUser(user);
		if (result > 0) {
			return "redirect:/main";
		} else {
			return "redirect:/signup";
		}

	}

	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}

	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {

		// 로그인처리로직

		System.out.println("로그인 시 입력한 값");
		System.out.println(user);

		// 사용자가 입력한 id pw -> DB 비교

		// id pw 맞으면 로그인 성공?
		// userType

		user.setUserType(commonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		// 성공//실패

		if (loginUser == null) { // 실패
			System.out.println("로그인실패");
			return "customer/signin";
		} else { // 성공
			System.out.println("로그인성공");
			System.out.println(loginUser);

			// 로그인 성공 -> 세션에 아이디 저장
			// session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLoginUserId(session, loginUser.getId());

			// return "redirect:/main";
			return "redirect:/customer/mypage"; // 로그인 성공 후 마이페이지로 연결
		}
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		// 로그인되어있는 사용자의 정보가 표시

		// 현재 누가 로그인한 상태? -> session 에 있는 "loginUserId" 키값으로 들어있는 아이디 확인

		// 아이디를 기반으로 조회

		// if( session.getAttribute("loginUserId") != null ) { //로그인 상태
		if (LoginManager.isLogin(session)) {

			// String loginUserId = session.getAttribute("loginUserId").toString();
			String loginUserId = LoginManager.getLoginUserId(session);

			User user = userService.findUserById(loginUserId);

			// view 전달
			model.addAttribute("user", user);

			return "customer/mypage";
		}

		// 로그인이 안되어있으면?? -> 로그인 페이지로 연결
		return "redirect:/customer/signin";
	}

	@GetMapping("/customer/signout")
	public String signout(HttpSession session) {

		// 세션 초기화
		// session.invalidate();
		LoginManager.logout(session);

		return "redirect:/main";
	}

	// 1) 비밀번호 변경 페이지 이동 (GET)
	@GetMapping("/customer/modifyPw")
	public String modifyPw(HttpSession session, Model model) {
		// 로그인 상태 확인
		if (LoginManager.isLogin(session)) {
			String loginUserId = LoginManager.getLoginUserId(session);
			User user = userService.findUserById(loginUserId);
			model.addAttribute("user", user);
		} else {
			return "redirect:/customer/signin";
		}

		return "customer/modifyPw";
	}
//			return "customer/modifyPw"; // 비밀번호 변경 화면 렌더링
//		}
//		// 로그인 안 되어있으면 로그인 페이지로 이동
//		return "redirect:/customer/signin";

	// 3) 비밀번호 변경 처리 (POST)
	@PostMapping("/customer/modifyPw")
	public String modifyPwAction(HttpSession session, String newPassword) {
		// 로그인 상태 확인
		if (LoginManager.isLogin(session)) {
			// 세션에서 현재 로그인된 사용자 ID 가져오기
			String loginUserId = LoginManager.getLoginUserId(session);

			// User 객체에 ID와 새 비밀번호 세팅
			User user = new User();
			user.setId(loginUserId);
			user.setPw(newPassword); // DTO의 비밀번호 필드명(pw, password 등)에 맞게 수정하세요.

			// Service를 통해 DB 비밀번호 업데이트 로직 호출 (해당 메서드는 Service에 구현해야 함)
			userService.updateUserPassword(user);

			// 4) 요구사항: 변경된 비밀번호로 다시 로그인해야 정상 로그인되는지 확인
			// 비밀번호 변경 후 로그아웃 처리하여 재로그인 유도
			LoginManager.logout(session);

			return "redirect:/customer/signin";
		}

		return "redirect:/customer/signin";
	}

	@GetMapping("/customer/modifyPw2")
	public String modifyPw2() {
		return "customer/modifyPw2";
	}

	@PostMapping("/customer/modifyPw2")
	public String modifyPw2Action(User user, HttpSession session) {
		// user 객체에는 사용자가 입력한 바꿀 비번 데이터 1개만 존재
		// 비번 바꾸려는 사용자 pk id 필요/세팅
		// mypage -> 비번변경페이지
		// 로그인 O -> session 로그인 사용자 아이디 존재

		// set pw = ?
		// where id = ?

		user.setId(LoginManager.getLoginUserId(session));

		// user 객체
		// 로그인한 id
		// 바꿀 pw

		System.out.println(user);

		int result = userService.updateUserPassword(user);

		if (result > 0) {
			return "redirect:/customer/mypage";
		} else {
			return "redirect:/customer/modifyPw";

		}
	}
}
