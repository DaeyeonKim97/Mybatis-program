package com.dykim.crud.remix;

import java.util.List;
import java.util.Map;

public class MenuController {
	
	private final MenuService menuService; //상태의 불변 처리 
	private final PrintResult printResult;
	
	public MenuController() {
		this.menuService = new MenuService();
		this.printResult = new PrintResult();
	}

	public void selectAllMenu() {
		
		//1. 뷰에서 전달한 파라미터 전달 받기 -> 없음 
		//2. 전달 받은 파라미터 유효성 검사 -> 없음 
		
		//3. 비즈니스 로직 수행(Service 메소드 호출)
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		
		//4. 사용자에게 응답(뷰 연결)
		if(menuList != null) {
			printResult.printMenuList(menuList);
		}
		else {
			printResult.printErrorMessage("selectList");
		}
	}

	public void selectMenuByCode(Map<String, String> parameter) {
		
		//1. 파라미터 전달 받기
		int code = Integer.parseInt(parameter.get("code"));
		
		//2. 전달 받은 파라미터 유효성 검사 
		
		//3. 비즈니스로직 수형
		MenuDTO menu = menuService.selectMenuByCode(code);
		
		//4. 사용자에게 응답
		if(menu != null) {
			printResult.printMenu(menu);
		}
		else {
			printResult.printErrorMessage("selectOne");
		}
		
	}

	public void registMenu(Map<String, String> parameter) {
		//1. 뷰에서 파라미터 전달 받기
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		
		//2. 전달받은 파라미터 유효성 검사
		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		try {
			menu.setPrice(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		menu.setCategoryCode(categoryCode);
		
		//3. 비즈니스 로직 수행 (Service 메소드 호출)
		//4. 사용자에게 응답 (뷰 연결)
		if(menuService.registMenu(menu)) {
			printResult.printSuccessMessage("insert");
		}
		else {
			printResult.printErrorMessage("insert");
		}
	}

	public void modifyMenu(Map<String, String> parameter) {
		//1. 뷰에서 파라미터 전달 받기
		int code = Integer.parseInt(parameter.get("code"));
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		
		//2. 전달받은 파라미터 유효성 검사 
		MenuDTO menu = new MenuDTO();
		menu.setCode(code);
		menu.setName(name);
		try {
			menu.setPrice(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		menu.setCategoryCode(categoryCode);
		
		//3. 비즈니스 로직 수행 
		if(menuService.modifyMenu(menu)) {
			printResult.printSuccessMessage("modify");
		}
		else {
			printResult.printErrorMessage("modify");
		}
	}

	public void deleteMenu(Map<String, String> parameter) {
		//1. 뷰에서 파라미터 전달 받기
		int code = Integer.parseInt(parameter.get("code"));
		
		//2. 전달받은 파라미터 유효성 검사 
		MenuDTO menu = new MenuDTO();
		menu.setCode(code);
		
		//3. 비즈니스 로직 수행 
		if(menuService.deleteMenu(menu)) {
			printResult.printSuccessMessage("delete");
		}
		else {
			printResult.printErrorMessage("delete");
		}
		
	}

}
