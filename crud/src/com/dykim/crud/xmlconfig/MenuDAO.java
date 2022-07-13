package com.dykim.crud.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuDAO {

	public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
		//1. 쿼리 실행
		//2. 결과 매핑
		//3. 매핑 결과 리턴
		return sqlSession.selectList("MenuMapper.selectAllMenu");

	}

}
