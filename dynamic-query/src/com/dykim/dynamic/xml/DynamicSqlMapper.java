package com.dykim.dynamic.xml;

import java.util.List;
import java.util.Map;

import com.dykim.dynamic.common.MenuDTO;
import com.dykim.dynamic.common.SearchCriteria;

public interface DynamicSqlMapper {

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

	List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByRandomCode(Map<String, List<Integer>> criteria);

	List<MenuDTO> searchMenuBycodeOrSearchAll(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> searchCriteria);

	int modifyMenu(Map<String, Object> changeInfo);

}
