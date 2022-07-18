package com.dykim.mapperelement.xmlmapper;

import java.util.List;

import com.dykim.mapperelement.common.CategoryAndMenuDTO;
import com.dykim.mapperelement.common.MenuAndCategoryDTO;
import com.dykim.mapperelement.common.MenuDTO;

public interface ElementTestMapper {

	List<String> selectCacheTest();

	List<MenuDTO> selectResultMapTest();

	List<MenuDTO> selectResultMapConstructorTest();

	List<MenuAndCategoryDTO> selectResultMapAssociation();

	List<CategoryAndMenuDTO> selectResultMapCollectionTest();

	List<MenuDTO> selectSqlTest();

}
