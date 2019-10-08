package com.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao implements ConnectionMaker {

	@Override
	public Connection makeConnetion() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url    = "jdbc:oracle:thin:@211.238.142.124:1521:orcl";
		String userId = "HRSPRING";
		String passwd = "HRSPRING1026";
		//-----------------------------------------------------
		//01.DB 연결
		//-----------------------------------------------------
		Connection c = DriverManager.getConnection(url,userId,passwd);
		
		return c;
	}

}
