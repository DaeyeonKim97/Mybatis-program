package com.dykim.crud.remix;

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
		case "selectOne":
			errorMessage = "메뉴 조회에 실패하셨습니다. ";
			break;
		case "insert":
			errorMessage = "신규 메뉴 등록에 실패하셨습니다.";
			break;
		case "modify":
			errorMessage = "메뉴 수정에 실패하셨습니다.";
			break;
		case "delete":
			errorMessage = "메뉴 삭제에 실패하셨습니다.";
			break;
		default:
			break;
		}
		
		System.out.println(errorMessage);
	}

	public void printMenu(MenuDTO menu) {
		System.out.println(menu);
		
	}

	public void printSuccessMessage(String code) {
		String successMessage = "";
		switch(code) {
		case "insert" : 
			successMessage = "신규 메뉴 등록에 성공하셨습니다. ";
			break;
		case "modify" :
			successMessage = "메뉴 수정에 성공하셨습니다. ";
		case "delete" :
			successMessage = "메뉴 삭제에 성공하셨습니다. ";
		}
		System.out.println(successMessage);
		
	}

}
