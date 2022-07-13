package com.dykim.crud.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.dykim.crud.xmlconfig.Template.getSqlSession;
import static com.dykim.crud.xmlconfig.Template.close;

public class MenuService {

	public List<MenuDTO> selectAllMenu() {
		//1.connection(sqlSession) 생성 
		SqlSession sqlSession = getSqlSession();
		
		//2. 비즈니스 로직 수행(DAO)들을 호출
		MenuDAO menuDAO = new MenuDAO();
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		
		//3. 트랜잭션 제어 (필요하다면)
		
		//4. connection(sqlSession) 닫기
		close(sqlSession);
		
		
		//5. 요청한 쪽으로 결과를 반환 
		return menuList;
	}

}
