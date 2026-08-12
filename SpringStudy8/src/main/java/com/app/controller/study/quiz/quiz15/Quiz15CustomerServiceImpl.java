package com.app.controller.study.quiz.quiz15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz15CustomerServiceImpl implements Quiz15CustomerService{

	@Autowired
	Quiz15CustomerDAO quiz15CustomerDAO;
	
	@Override
	public int saveCustomer(Quiz15Customer Quiz15Customer) {
		
		System.out.println("[service] CustomerService");
		//서비스 로직
		
		int result = quiz15CustomerDAO.saveCustomer(quiz15Customer);
		return result;
	}
}
