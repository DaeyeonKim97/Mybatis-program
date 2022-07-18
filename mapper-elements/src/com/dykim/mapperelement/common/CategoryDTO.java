package com.dykim.mapperelement.common;

public class CategoryDTO {
	private int code;
	private String name;
	private Integer refCategorycode; //null 허용 카테고리이기 때문에 Integer Wrapper class를 사용함.
	
	public CategoryDTO() {
		
	}

	public CategoryDTO(int code, String name, Integer refCategorycode) {
		super();
		this.code = code;
		this.name = name;
		this.refCategorycode = refCategorycode;
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


	@Override
	public String toString() {
		return "CategoryDTO [code=" + code + ", name=" + name + ", refCategorycode=" + refCategorycode + "]";
	}
	
}
