package com.dykim.crud.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.dykim.crud.xmlconfig.Template.getSqlSession;
import static com.dykim.crud.xmlconfig.Template.close;

public class MenuService {
	
	private final MenuDAO menuDAO;
	
	public MenuService() {
		menuDAO = new MenuDAO();
	}

	public List<MenuDTO> selectAllMenu() {
		//1.connection(sqlSession) 생성 
		SqlSession sqlSession = getSqlSession();
		
		//2. 비즈니스 로직 수행(DAO)들을 호출
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		
		//3. 트랜잭션 제어 (필요하다면)
		
		//4. connection(sqlSession) 닫기
		close(sqlSession);
		
		
		//5. 요청한 쪽으로 결과를 반환 
		return menuList;
	}

	
	public MenuDTO selectMenuByCode(int code) {
		SqlSession sqlSession = getSqlSession();
		
		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		
		close(sqlSession);
		
		return menu;
		
	}

	public boolean registMenu(MenuDTO menu) {
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.insertMenu(sqlSession,menu);
		
		//3. 트랜잭션 제어
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		
		close(sqlSession);
		return result > 0;
	}

	public boolean modifyMenu(MenuDTO menu) {
		//1. 커넥션생성
		SqlSession sqlSession = getSqlSession();
		
		//2. 비즈니스 로직 수행 (DAO)
		int result = menuDAO.modifyMenu(sqlSession,menu);
		
		//3. 트랜잭션 제어
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		//4. 커넥션 종료 
		close(sqlSession);
		return result > 0;
		
	}

	public boolean deleteMenu(MenuDTO menu) {
		//1. 커넥션생성
		SqlSession sqlSession = getSqlSession();
		
		//2. 비즈니스 로직 수행 (DAO)
		int result = menuDAO.deleteMenu(sqlSession,menu);
		
		//3. 트랜잭션 제어
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		//4. 커넥션 종료 
		close(sqlSession);
		return result > 0;
	}

}
