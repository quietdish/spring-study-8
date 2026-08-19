package com.app.controller.study.rest;

import java.util.List;

import lombok.Data;

@Data
public class ApiDelivery {

	String staffName;
	String destination;
	String phone;
	
	ApiStore apiStore;
	List<ApiMenu> menuList;
	
}
