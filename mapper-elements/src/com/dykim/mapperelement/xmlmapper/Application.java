package com.dykim.mapperelement.xmlmapper;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ElementTestService elementTestService = new ElementTestService();
		
		do {
			System.out.println("=====매퍼 elements 테스트 메뉴=====");
			System.out.println("1.<cache> test");
			System.out.println("2.<resultMap> subMenu");
			System.out.println("3.<sql> test");
			System.out.println("4.<insert> subMenu");
			
			int no = sc.nextInt();
			
			switch (no) {
			case 1:
				elementTestService.selectCacheTest();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;

			}
			
		}while(true);
	}

}
