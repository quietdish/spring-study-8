package com.app.controller.study.quiz.quiz14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quiz14Configuration {

	//Bean 등록 설정
	@Bean
	public CoffeeBean coffeeBean() {
		
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("민트초코프라페");
		
		return coffeeBean;
	}
	
	
	@Bean
	public DessertBean dessertBean() {
		
		DessertBean dessertBean = new DessertBean();
		dessertBean.setName("당근케이크");
		
		return dessertBean;
	}
	
	
	@Bean
	public CupBean cupBean() {
		
		CupBean cupBean = new CupBean();
		cupBean.setCoffeeBean(coffeeBean());
		
		return cupBean;
	}
	
	
	@Bean
	public PlateBean plateBean() {
		
		PlateBean plateBean = new PlateBean();
		plateBean.setDessertBean(dessertBean());
		
		return plateBean;
	}
}
