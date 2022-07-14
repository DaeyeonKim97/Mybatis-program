package com.dykim.crud.remix;

import java.util.List;

public interface MenuMapper {

	
	List<MenuDTO> selectAllMenu();

	MenuDTO selectMenuByCode(int code);

	int insertMenu(MenuDTO menu);

	int modifyMenu(MenuDTO menu);

	int deleteMenu(MenuDTO menu);

}
