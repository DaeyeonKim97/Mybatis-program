package com.dykim.crud.xmlconfig;

import java.awt.Label;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MenuController menuController = new MenuController();
		
		do {
			System.out.println("=== 메뉴 관리 ===");
			System.out.println("1. 메뉴 전체 조회 ");
			System.out.println("2. 메뉴 코드로 메뉴 조회  ");
			System.out.println("3. 신규 메뉴 추가  ");
			System.out.println("4. 메뉴 수정  ");
			System.out.println("5. 메뉴 삭제  ");
			System.out.println("0. 종료  ");
			
			int cmd = sc.nextInt();
			if(cmd==0)
				break;
			
			switch(cmd) {
				case 1: 
					menuController.selectAllMenu(); 
					break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				default: break;
			}
			
			
		} while(true);
		
	}
}
