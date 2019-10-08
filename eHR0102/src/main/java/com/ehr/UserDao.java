/**
 * @Class Name : User.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-08-19           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019-08-19 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class UserDao {
	static final Logger LOG = Logger.getLogger(UserDao.class);
	
	//중복코드의 메소드 추출
	//-----------------------------------------------------
	//01.DB 연결
	//-----------------------------------------------------
	
	public Connection getConnection()throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url    = "jdbc:oracle:thin:@211.238.142.124:1521:orcl";
		String userId = "HRSPRING";
		String passwd = "HRSPRING1026";
		//-----------------------------------------------------
		//01.DB 연결
		//-----------------------------------------------------
		Connection c = DriverManager.getConnection(url,userId,passwd);
		LOG.debug("=================================");
		LOG.debug("01. c=" + c);
		LOG.debug("=================================");
		
		return c;
	}
	
	
	/**
	 * 
	 * @Method Name  : add
	 * @작성일   : 2019. 8. 19.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 단건등록
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int add(User user)throws ClassNotFoundException,SQLException{
		//-----------------------------------------------------
		//01.DB 연결
		//-----------------------------------------------------
		Connection c = getConnection();
		
		//-----------------------------------------------------
		//02. SQL작성
		//-----------------------------------------------------
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO users ( \n");
		sb.append("     u_id,           \n");
		sb.append("     name,           \n");
		sb.append("     passwd          \n");
		sb.append(" ) VALUES (          \n");
		sb.append("     ?,              \n");
		sb.append("     ?,              \n");
		sb.append("     ?               \n");
		sb.append(" )                   \n");
		
		LOG.debug("=================================");
		LOG.debug("02. sql=" + sb.toString());
		LOG.debug("=================================");
		
		//-----------------------------------------------------
		//03. PreparedStatement
		//-----------------------------------------------------
		PreparedStatement ps = c.prepareStatement(sb.toString());
		ps.setString(1, user.getU_id());
		ps.setString(2,user.getName());
		ps.setString(3, user.getPasswd());
		LOG.debug("=================================");
		LOG.debug("03. paam=" + user);
		LOG.debug("=================================");
		
		//-----------------------------------------------------
		//04. Run sql
		//-----------------------------------------------------
		int flag = ps.executeUpdate();
		LOG.debug("=================================");
		LOG.debug("04. Run flag=" + flag);
		LOG.debug("=================================");
		
		//-----------------------------------------------------
		//05. 자원반납
		//-----------------------------------------------------
		ps.close();
		c.close();
		
		return flag;
		
	}
	/**
	 * 
	 * @Method Name  : get
	 * @작성일   : 2019. 8. 19.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 단건조회
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public User get(String id)throws ClassNotFoundException,SQLException{
		User outVO =null;
		//-----------------------------------------------------
		//01.DB 연결
		//-----------------------------------------------------
		Connection c = getConnection();
		
		//-----------------------------------------------------
		//02. SQL작성
		//-----------------------------------------------------
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT      \n");
		sb.append("     u_id,   \n");
		sb.append("     name,   \n");
		sb.append("     passwd  \n");
		sb.append(" FROM        \n");
		sb.append("     users   \n");
		sb.append(" WHERE u_id = ?  \n");
		
		LOG.debug("=================================");
		LOG.debug("02. sql=" + sb.toString());
		LOG.debug("=================================");
		
		//-----------------------------------------------------
		//03. PreparedStatement
		//-----------------------------------------------------
		PreparedStatement ps = c.prepareStatement(sb.toString());
		ps.setString(1, id);
		LOG.debug("=============================");
		LOG.debug("03. id="+id);
		LOG.debug("=============================");	
		
		//----------------------------------------
		//04.Run sql
		//----------------------------------------	
		//읽어오기
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			outVO = new User();
			outVO.setU_id(rs.getString("u_id"));
			outVO.setName(rs.getString("name"));
			outVO.setPasswd(rs.getString("passwd"));
		}
		
		LOG.debug("=============================");
		LOG.debug("04. Run outVO="+outVO);
		LOG.debug("=============================");	
		
		//-----------------------------------------------------
		//05. 자원반납
		//-----------------------------------------------------
		ps.close();
		c.close();
		rs.close();
		
		return outVO;
	}

	public static void main(String[] args) {
		LOG.debug("==============================");
		LOG.debug("=00 main=");
		LOG.debug("==============================");
		//j01_ip: j01_134
		UserDao dao = new UserDao();
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
				LOG.debug("========================================");
				LOG.debug("=02.01 단건조회 성공="+ user01.getU_id());
				LOG.debug("========================================");
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
