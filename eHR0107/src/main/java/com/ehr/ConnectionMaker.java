package com.ehr;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	public Connection makeConnetion() throws ClassNotFoundException,SQLException;
}
