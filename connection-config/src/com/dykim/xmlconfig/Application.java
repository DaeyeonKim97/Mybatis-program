package com.dykim.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application {
	public static void main(String[] args) {
		String resource = "com/dykim/xmlconfig/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession(false);
			
			System.out.println("sqlSession : "+sqlSession);
			
			java.util.Date date = sqlSession.selectOne("mapper.selectSysdate");//어떤 xml파일의 쿼리인지 확인하기 위해서 namespace. 으로 써줘야됨.
			System.out.println(date);
			
			sqlSession.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
