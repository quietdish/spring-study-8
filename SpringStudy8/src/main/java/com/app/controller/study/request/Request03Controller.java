package com.app.controller.study.request;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request03")
public class Request03Controller {

	// localhost:8080/request03/param1?msg=hi&page=1&level=5
	@GetMapping("/param1")
	public String param1(HttpServletRequest request) {
		
		System.out.println("/request03/param1");
		System.out.println( request.getParameter("msg"));
		System.out.println( request.getParameter("page"));
		System.out.println( request.getParameter("level"));
		
		return "req/param/param1";
		
	}
	
	//localhost:8080/request03/param2?name=abc&count=123
	@PostMapping("/param2")
	public String param2(HttpServletRequest request) {
		System.out.println("/request03/param2");
		System.out.println( request.getParameter("name"));
		System.out.println( request.getParameter("count"));
		
		return "req/param/param2";
	}
	
	
	@GetMapping("/param3")
	public String param3(HttpServletRequest request) {
	
		//localhost:8080/request03/param3?p1=10&p2=20&p3=30
		// 여러개의 값을 가진 파라미터를 읽어야될때
		String[] p3Values = request.getParameterValues("p3");
		
		System.out.println("/request03/param3");
		System.out.println( request.getParameter("p1"));
		System.out.println( request.getParameter("p2"));
		System.out.println( request.getParameter("p3"));
		
		//localhost:8080/request03/param3?p1=10&p2=20&p3=30&p3=40
		// 여러개의 값을 가진 파라미터를 읽어야될때
		String[] p3Values = request.getParameterValues("p3");
		for(String s: p3Values) {
			System.out.println(s);
		}
				
		return "req/param/param2";
	}
	
	
	@RequestMapping("/param4")	//get post
	public String param4(@RequestParam String p1, @RequestParam String p2) {
		//localhost:8080/request03/param4?p1=10&p2=20
		
		System.out.println("/request03/param4");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param5")	//get post
	public String param5(@RequestParam String p1, @RequestParam(required = false) String p2) {
		//localhost:8080/request03/param5?p1=10&p2=20			//필수X 없어도됨
		
		System.out.println("/request03/param5");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	
	@RequestMapping("/param6")	//get post
	public String param6(@RequestParam String p1, 
						@RequestParam(required = false, defaultValue = "p2Default") String p2) {
		//localhost:8080/request03/param6?p1=10&p2=20			//필수X 없어도됨
		
		System.out.println("/request03/param6");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	
	@RequestMapping("/param7")
	public String param7(@RequestParam Map<String, String> paramMap) {
		// 요청에 담겨져서 넘어오는 파라미터 값들...
		// p1=10&p2=20		key:value
		
		//localhost:8080/request03/param7?p1=10&p2=20&count=9999
		//localhost:8080/request03/param7?p1=10&p2=20&count=9999&msg=hihi&time-1237&etc=21fj
		
		System.out.println("/param7");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("count"));
		
		System.out.println("-------");
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : " + paramMap.get(key));
		}
		
		return "req/param/param2";
		
	}
}
