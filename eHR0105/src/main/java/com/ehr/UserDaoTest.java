package com.ehr;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserDaoTest {
	static final Logger LOG = Logger.getLogger(UserDaoTest.class);

	public static void main(String[] args) {
		//j01_ip: j01_134
		
		//1. UserDao가 사용할 ConnectionMaker를 결정
		ConnectionMaker connectionMaker = new DUserDao();
		//ConnectionMaker connectionMaker2 = new NUserDao();
		
		//2.UserDao생성
		//2.1 사용할 ConnectionMaker타입의 Object제공
		//2.2 UserDao와 ConnectionMaker의 의존 관계결정
		UserDao dao = new UserDao(connectionMaker);
		
		User user01 = new User("j01_134","송영은","1234");
		try {
			LOG.debug("=================================");
			LOG.debug("=01 단건등록=");
			LOG.debug("=================================");
			
			int flag = dao.add(user01);
			LOG.debug("=================================");
			LOG.debug("=01.01 add flag=" + flag);
			LOG.debug("=================================");
			
			if(flag == 1) {
				LOG.debug("=================================");
				LOG.debug("=01.02 단건등록 성공=" + user01.getU_id());
				LOG.debug("=================================");
			}
			
			LOG.debug("=================================");
			LOG.debug("=02 단건조회=");
			LOG.debug("=================================");
			
			User userOne = dao.get(user01.getU_id());
			if(user01.getU_id().equals(userOne.getU_id()) 
					&&user01.getName().equals(userOne.getName())
					&&user01.getPasswd().equals(userOne.getPasswd())
					) {
				LOG.debug("******************************************");
				LOG.debug("=02.01 단건조회 성공="+ user01.getU_id());
				LOG.debug("******************************************");
			}else {
				LOG.debug("========================================");
				LOG.debug("=02.01 단건조회 실패="+ user01.getU_id());
				LOG.debug("========================================");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
