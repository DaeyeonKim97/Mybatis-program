package com.dykim.crud.xmlconfig;

import java.util.List;

public class PrintResult {

	public void printMenuList(List<MenuDTO> menuList) {
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
		
	}

	public void printErrorMessage(String errorCode) {
		String errorMessage = "";
		switch (errorCode) {
		case "selectList":
			errorMessage = "메뉴 목록 조회에 실패하셨습니다. ";
			break;

		default:
			break;
		}
		
		System.out.println(errorMessage);
	}

}
