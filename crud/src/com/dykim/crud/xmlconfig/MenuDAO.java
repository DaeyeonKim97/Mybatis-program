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

	public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) { //한개 값만 전달할 수 있음 
		return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
	}

	public int insertMenu(SqlSession sqlSession, MenuDTO menu) { //한 개 값만 전달해줄 수 있으므로 뭉쳐서 전달해야 함.
		return sqlSession.insert("MenuMapper.insertMenu", menu);
	}

	public int modifyMenu(SqlSession sqlSession, MenuDTO menu) {
		return sqlSession.update("MenuMapper.modifyMenu", menu);
	}

	public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {
		return sqlSession.update("MenuMapper.deleteMenu", menu);
	}

}
