package com.ehr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 컨텍스트 또는 빈팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {
	
	//오브젝트 생성을 담당하는 IoC용 메소드
	@Bean
	public UserDao userDao() {
		
		//1. UserDao가 사용할 ConnectionMaker를 결정
		//ConnectionMaker connectionMaker = new DUserDao(); //중복코드
		
		//2.UserDao생성
		//2.1 사용할 ConnectionMaker타입의 Object제공
		//2.2 UserDao와 ConnectionMaker의 의존 관계결정
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new DUserDao();
	}
	

}
