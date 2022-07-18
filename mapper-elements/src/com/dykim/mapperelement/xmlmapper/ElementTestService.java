package com.dykim.mapperelement.xmlmapper;

import static com.dykim.mapperelement.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
	
}
