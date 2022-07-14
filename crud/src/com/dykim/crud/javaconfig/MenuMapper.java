package com.dykim.crud.javaconfig;

import java.util.List;



import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Result;

import org.apache.ibatis.annotations.ResultMap;

import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Select;


public interface MenuMapper { //DAO대신 Mapper사용 

	
	@Results(id="menuResultMap", value= {

			@Result(id = true, property = "code", column = "MENU_CODE"),

			@Result(property = "name", column = "MENU_NAME"),

			@Result(property = "price", column = "MENU_PRICE"),

			@Result(property = "categoryCode", column = "CATEGORY_CODE"),

			@Result(property = "orderableStatus", column = "ORDERABLE_STATUS")

	})

	@Select("SELECT \n"

	      + "       A.MENU_CODE \n"

	      + "     , A.MENU_NAME \n"

	      + "     , A.MENU_PRICE \n"

	      + "     , A.CATEGORY_CODE \n"

	      + "     , A.ORDERABLE_STATUS \n"

	      + "  FROM TBL_MENU A \n"

	      + " WHERE A.ORDERABLE_STATUS = 'Y' \n"

	      + " ORDER BY A.MENU_CODE")
	List<MenuDTO> selectAllMenu();

	
	@Select("SELECT \n"

		  + "       A.MENU_CODE \n"

		  + "     , A.MENU_NAME \n"

		  + "     , A.MENU_PRICE \n"

		  + "     , A.CATEGORY_CODE \n"

		  + "     , A.ORDERABLE_STATUS \n"

		  + "  FROM TBL_MENU A \n"

		  + " WHERE A.ORDERABLE_STATUS = 'Y' \n"

		  + "   AND A.MENU_CODE = #{ code }")

	@ResultMap("menuResultMap")

	MenuDTO selectMenuByCode(int code);


	@Insert("INSERT \n"

		  + "  INTO TBL_MENU A \n"

		  + "("

		  + "  A.MENU_CODE \n"

		  + ", A.MENU_NAME \n"

		  + ", A.MENU_PRICE \n"

		  + ", A.CATEGORY_CODE \n"

		  + ", A.ORDERABLE_STATUS \n"

		  + ") \n"

		  + "VALUES \n"

		  + "("

		  + "  SEQ_MENU_CODE.NEXTVAL \n"

		  + ", #{ name } \n"

		  + ", #{ price } \n"

		  + ", #{ categoryCode } \n"

		  + ", 'Y' \n"

		  + ")")

	int insertMenu(MenuDTO menu);

	
	
}

