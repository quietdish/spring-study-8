package com.app.controller.study.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.common.commonCode;
import com.app.controller.study.request.Request01Controller;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.User;

@RestController
public class Rest03Controller {

	// API 요청에 대해 JSON 응답

	// json -> header, body 영역으로 나눠서 응답

	private final Request01Controller request01Controller;

	Rest03Controller(Request01Controller request01Controller) {
		this.request01Controller = request01Controller;
	}

	@GetMapping("/rest/object1")
	public ApiMenu object1() {

		ApiMenu apiMenu = new ApiMenu("아메리카노", 2000);

		return apiMenu;
	}

	@GetMapping("/rest/object2")
	public List<ApiMenu> object2() {

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();

		menuList.add(new ApiMenu("아메리카노", 2000));
		menuList.add(new ApiMenu("카페라떼", 3000));
		menuList.add(new ApiMenu("아이스티", 4000));
		menuList.add(new ApiMenu("레몬티", 3500));

		return menuList;
	}

	@GetMapping("/rest/object3")
	public ApiDelivery object3() {

		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDestination("중앙동 214번지");
		apiDelivery.setPhone("010-123-4567");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("맥도날드");
		apiStore.setAddress("서동");
		apiStore.setTel("041-111-1111");

		apiDelivery.setApiStore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();

		menuList.add(new ApiMenu("아메리카노", 2000));
		menuList.add(new ApiMenu("카페라떼", 3000));
		menuList.add(new ApiMenu("아이스티", 4000));
		menuList.add(new ApiMenu("레몬티", 3500));

		apiDelivery.setMenuList(menuList);

		return apiDelivery;

	}

	@GetMapping("/rest/response1")
	public int response1() {

		return 30;
	}

	@GetMapping("/rest/response2")
	public ApiResponseHeader response2() {
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();

		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		return apiResponseHeader;

	}

	@GetMapping("/rest/response3")
	public ApiResponseDelivery response3() {

		// hearder
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		// body

		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDestination("중앙동 214번지");
		apiDelivery.setPhone("010-123-4567");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("맥도날드");
		apiStore.setAddress("서동");
		apiStore.setTel("041-111-1111");

		apiDelivery.setApiStore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();

		menuList.add(new ApiMenu("아메리카노", 2000));
		menuList.add(new ApiMenu("카페라떼", 3000));
		menuList.add(new ApiMenu("아이스티", 4000));
		menuList.add(new ApiMenu("레몬티", 3500));

		apiDelivery.setMenuList(menuList);

		// 최종 응답 객체
		ApiResponseDelivery apiResponseDelivery = new ApiResponseDelivery();
		apiResponseDelivery.setHearder(apiResponseHeader);
		apiResponseDelivery.setBody(apiDelivery);

		return apiResponseDelivery;

	}

	@GetMapping("/rest/response4")
	public ApiResponse<ApiDelivery> response4() {
	
		ApiResponse<String> r1;
		ApiResponse<Integer> r2;
		ApiResponse<ApiDelivery> r3;
		ApiResponse<ApiMenu> r4;
		ApiResponse<User> r5;
		ApiResponse< List<User> > r6;
		
		
		
		// hearder
				ApiResponseHeader apiResponseHeader = new ApiResponseHeader(); 		
				apiResponseHeader.setResultCode( ApiCommonCode.API_RESULT_SUCCESS);
				apiResponseHeader.setResultMessage( ApiCommonCode.API_RESULT_SUCCESS_MSG);
			
				// body
				
				ApiDelivery apiDelivery = new ApiDelivery();

				apiDelivery.setStaffName("나배달");
				apiDelivery.setDestination("중앙동 214번지");
				apiDelivery.setPhone("010-123-4567");

				ApiStore apiStore = new ApiStore();
				apiStore.setName("맥도날드");
				apiStore.setAddress("서동");
				apiStore.setTel("041-111-1111");

				apiDelivery.setApiStore(apiStore);

				List<ApiMenu> menuList = new ArrayList<ApiMenu>();

				menuList.add(new ApiMenu("아메리카노", 2000));
				menuList.add(new ApiMenu("카페라떼", 3000));
				menuList.add(new ApiMenu("아이스티", 4000));
				menuList.add(new ApiMenu("레몬티", 3500));
				
				apiDelivery.setMenuList(menuList);
				
				
				//최종 응답 객체
				ApiResponseDelivery apiResponseDelivery = new ApiResponseDelivery();
				apiResponseDelivery.setHearder(apiResponseHeader);
				apiResponseDelivery.setBody(apiDelivery);
				
		
		ApiResponse<ApiDelivery> apiResponse = new ApiResponse<ApiDelivery>();
		apiResponse.setHeader(apiResponseHeader);
		apiResponse.setBody(apiDelivery);
		
		return apiResponse;
		
	}
	
	
	@GetMapping("/rest/response5")
	public ApiResponse<User> response5() {

		// hearder
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader(); 		
		apiResponseHeader.setResultCode( ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage( ApiCommonCode.API_RESULT_SUCCESS_MSG);
	
		// body
		User user = new User();
		user.setId("idid");
		user.setPw("pwpw");
		user.setName("namename");
		user.setUserType(commonCode.USER_USERTYPE_ADMIN);
		
		
		
		ApiResponse<User> apiResponse = new ApiResponse<User>();
		apiResponse.setHeader(apiResponseHeader);
		apiResponse.setBody(user);
		
		return apiResponse;
	}
}
