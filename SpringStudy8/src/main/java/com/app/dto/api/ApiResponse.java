package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	ApiResponseHeader header;
	T body;
	
//	List<String>
//	List<Menu>
//	List<User>
	
	
	
	
	
}
