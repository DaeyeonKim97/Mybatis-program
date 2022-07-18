package com.dykim.mapperelement.common;

import java.util.List;

public class CategoryAndMenuDTO {
	private int code;
	private String name;
	private Integer refCategorycode; //null 허용 카테고리이기 때문에 Integer Wrapper class를 사용함.
	private List<MenuDTO> menuList; //collection Type
	
	public CategoryAndMenuDTO() {
	}
	public CategoryAndMenuDTO(int code, String name, Integer refCategorycode, List<MenuDTO> menuList) {
		super();
		this.code = code;
		this.name = name;
		this.refCategorycode = refCategorycode;
		this.menuList = menuList;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRefCategorycode() {
		return refCategorycode;
	}
	public void setRefCategorycode(Integer refCategorycode) {
		this.refCategorycode = refCategorycode;
	}
	public List<MenuDTO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}
	@Override
	public String toString() {
		return "CategoryAndMenuDTO [code=" + code + ", name=" + name + ", refCategorycode=" + refCategorycode
				+ ", menuList=" + menuList + "]";
	}
	
	
	
}
