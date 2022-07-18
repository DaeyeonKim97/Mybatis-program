package com.dykim.mapperelement.xmlmapper;

import static com.dykim.mapperelement.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dykim.mapperelement.common.CategoryAndMenuDTO;
import com.dykim.mapperelement.common.MenuAndCategoryDTO;
import com.dykim.mapperelement.common.MenuDTO;

public class ElementTestService {

	public void selectCacheTest() {
		SqlSession sqlSession = getSqlSession();
		ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
		
		for(int i=0; i<10; i++) {
			Long startTime = System.currentTimeMillis();
			
			List<String> nameList = mapper.selectCacheTest();
			
			System.out.println(nameList);
			
			Long endTime = System.currentTimeMillis();
			
			Long interval = endTime - startTime;
			
			System.out.println("수행시간 : "+ interval);
		}
		
		List<String> nameList = mapper.selectCacheTest();
		System.out.println(nameList);
		
		sqlSession.close();
		
	}

	public void selectResultMap() {
		SqlSession sqlSession = getSqlSession();
		ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
		
		List<MenuDTO> menuList = mapper.selectResultMapTest();
		
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
		
		sqlSession.close();
	}

	public void selectResultMapConstructorTest() {
		SqlSession sqlSession = getSqlSession();
		
		ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
		
		List<MenuDTO> menuList = mapper.selectResultMapConstructorTest();
		
		for(MenuDTO menu:menuList)
			System.out.println(menu);
		
		sqlSession.close();
	}

	public void selectResultMapAssociationTest() {
		SqlSession sqlSession = getSqlSession();
		ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
		
		List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociation();
		
		for(MenuAndCategoryDTO menu : menuList)
			System.out.println(menu);
		
		sqlSession.close();
	}

	public void selectResultMapCollectionTest() {
		SqlSession sqlSession = getSqlSession();
		ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
		
		List<CategoryAndMenuDTO> categoryList = mapper.selectResultMapCollectionTest();
		
		for(CategoryAndMenuDTO category : categoryList) {
			System.out.println(category);
		}
		sqlSession.close();
	}
	
}
