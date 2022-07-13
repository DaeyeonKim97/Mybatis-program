package com.dykim.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class Application {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@mtvsdb_medium?TNS_ADMIN=/Users/dykim/keys/Wallet_MTVSdb";
	private static String user = "DYKIM";
	private static String password = "Rlaeodus1130" ;
	
	public static void main(String[] args) {
		Environment enviroment = new Environment("dev"					//환경정보 이름
				, new JdbcTransactionFactory()							//트랜젝션 매니저 종류 결정(JDBC or MANAGED)
				, new PooledDataSource(driver,url,user,password));		//Connection Pool 사용 유무 (Pooled or UnPooled)
		
		//생성한 환경 설정 정보를 가지고 마이바티스 설정 객체 생성 
		Configuration configuration = new Configuration(enviroment);
		//설정 객체에 매퍼 등록 설정 
		configuration.addMapper(Mapper.class);
		
		//SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할을 수행하는 인터페이스
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession(); //Connection객체와 비슷, Connection을 감싸고 있는 녀석 
		
		System.out.println(sqlSession);
		
		Mapper mapper = sqlSession.getMapper(Mapper.class); //MapperProxy를 만들어줌 (대신 역할을 수행), MapperProxy가 이미 Override를 다 해놓았음.

		java.util.Date date = mapper.selectSysdate();
		
		System.out.println(date); // ojdbc8.jar가 필요하다. 
		
		sqlSession.close();
		
	}
	
}
