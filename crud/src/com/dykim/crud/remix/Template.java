package com.dykim.crud.remix;


import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@mtvsdb_medium?TNS_ADMIN=/Users/dykim/keys/Wallet_MTVSdb";
	private final static String USER = "DYKIM";
	private final static String PASSWORD = "Rlaeodus1130";
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		if(sqlSessionFactory==null) {
			Environment environment = new Environment("dev"
					,new JdbcTransactionFactory()
					,new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			Configuration configuration = new Configuration(environment);
			
			configuration.addMapper(MenuMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		return sqlSessionFactory.openSession(false);
	}
}
