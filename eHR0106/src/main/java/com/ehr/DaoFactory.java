package com.ehr;

public class DaoFactory {
	
	/**
	 * UserDao.java
	 * BoardDao.java
	 * @return
	 */
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
	
	
//	public UserDao boardDao() {
//	
//	//1. UserDao가 사용할 ConnectionMaker를 결정 
//	ConnectionMaker connectionMaker = new DUserDao();
//	
//	//2.UserDao생성 
//	//2.1 사용할 ConnectionMaker타입의 Object제공 
//	//2.2 UserDao와
//	ConnectionMaker의 의존 관계결정 
//	UserDao dao = new boardDao(connectionMaker()); 
//	return dao; 
//	}
	
}
