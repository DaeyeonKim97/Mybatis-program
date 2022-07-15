package com.dykim.dynamic.xml;

import static com.dykim.dynamic.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dykim.dynamic.common.MenuDTO;
import com.dykim.dynamic.common.SearchCriteria;

public class MenuService {

	public void selectMenuByPrice(int price) {
		SqlSession sqlSession = getSqlSession();
		
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		System.out.println(mapper);
		
		//기본 자료형으로는 조건문의 값을 비교할 수 없다. hashmap의 key를 이용하여 get()을 이용하거나 dto의 getter를 이용하여 값을 확인한다.
		
		Map<String, Integer> map = new HashMap<>();
		map.put("price",price);
		
		List<MenuDTO> menuList = mapper.selectMenuByPrice(map);
		
		if(menuList != null && menuList.size() >0) {
			for(MenuDTO menu : menuList)
				System.out.println(menu);
		}
		else {
			System.out.println("검색결과가 존재하지 않습니다. ");
		}
		sqlSession.close();
	}

	public void searchMenu(SearchCriteria searchCriteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
		
		if(menuList != null && menuList.size()>0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}
		else {
			System.out.println("검색 결과가 없습니다. ");
		}
		sqlSession.close();
	}

	public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0)
		{
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}
		else {
			System.out.println("검색 결과가 존재하지 않습니다. ");
		}
		sqlSession.close();
	}

	public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", randomMenuCodeList);
		
		List<MenuDTO> menuList = mapper.searchMenuByRandomCode(criteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList)
				System.out.println(menu);
		}else {
			System.out.println("검색 결과가 존재하지 않습니다. ");
		}
		sqlSession.close();
	}

	public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBycodeOrSearchAll(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}
		else {
			System.out.println("검색 결과가 없습니다. ");
		}
		sqlSession.close();
	}

	public void searchMenuByNameOrCategory(Map<String, Object> searchCriteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}
		else {
			System.out.println("검색 결과가 없습니다. ");
		}
		sqlSession.close();
		
	}

	public void modifyMenu(Map<String, Object> changeInfo) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		int result = mapper.modifyMenu(changeInfo);
		
		if(result > 0) {
			System.out.println("메뉴 정보 변경에 성공하셨습니다.");
			sqlSession.commit();
		}else {
			System.out.println("메뉴 정보 변경에 실패하셨습니다. ");
			sqlSession.rollback();
		}
		sqlSession.close();
	}

}
