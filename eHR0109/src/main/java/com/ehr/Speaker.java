package com.ehr;

import org.apache.log4j.Logger;

public interface Speaker {
	public static Logger LOG=Logger.getLogger(Speaker.class);
	
	 void volumeUp();
	 void volumeDown();
}
