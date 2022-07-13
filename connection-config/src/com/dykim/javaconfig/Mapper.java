package com.dykim.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
	@Select("SELECT SYSDATE FROM DUAL") //Select Annotation Annotation은 런타임 시점에 체크하도록 함. 런타임 시점에 감지해서 실행해줌
	java.util.Date selectSysdate(); //public abstract 이 묵시적으로 생략되어 있음.
}
