package com.dykim.crud.xmlconfig;

import java.util.List;

public class MenuController {

	public void selectAllMenu() {
		
		//1. 뷰에서 전달한 파라미터 전달 받기 -> 없음 
		//2. 전달 받은 파라미터 유효성 검사 -> 없음 
		
		//3. 비즈니스 로직 수행(Service 메소드 호출)
		MenuService menuService = new MenuService();
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		
		//4. 사용자에게 응답(뷰 연결)
		PrintResult printResult = new PrintResult();
		
		
		if(menuList != null) {
			printResult.printMenuList(menuList);
		}
		else {
			printResult.printErrorMessage("selectList");
		}
	}

}
