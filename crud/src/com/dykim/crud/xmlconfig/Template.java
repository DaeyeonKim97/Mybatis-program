package com.dykim.crud.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//singleton

public class Template {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			String resource = "com/dykim/crud/xmlconfig/mybatis-config.xml";
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		return sqlSession;
	}
	
	public static void close(SqlSession sqlSession) {
		
	}
}
