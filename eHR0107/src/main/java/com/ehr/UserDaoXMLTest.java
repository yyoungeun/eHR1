package com.ehr;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoXMLTest {
	static final Logger LOG = Logger.getLogger(UserDaoXMLTest.class);

	public static void main(String[] args) {
		// j01_ip: j01_134

		// UserDao dao = new DaoFactory().userDao();
		// Spring IoC로 객체 생성

		AbstractApplicationContext context = new GenericXmlApplicationContext("/applicationContext.xml");
		LOG.debug("================================="); 
		LOG.debug("=context="+ context);
		LOG.debug("=================================");
	  

		UserDao dao = context.getBean("userDao", UserDao.class);
		UserDao dao02 = context.getBean("userDao", UserDao.class);
		UserDao dao03 = context.getBean("userDao", UserDao.class);
		LOG.debug("=================================");
		LOG.debug("=01 dao=" + dao);
		LOG.debug("=01 dao02=" + dao02);
		LOG.debug("=01 dao03=" + dao03);
		LOG.debug("=================================");

		
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
					  &&user01.getPasswd().equals(userOne.getPasswd()) ){
				  LOG.debug("******************************************");
				  LOG.debug("=02.01 단건조회 성공="+ user01.getU_id());
				  LOG.debug("******************************************"); 
			  
				  }else {
				  LOG.debug("========================================");
				  LOG.debug("=02.01 단건조회 실패="+ user01.getU_id());
				  LOG.debug("========================================"); 
				  }
			  }catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); 
			  }
	}
}
