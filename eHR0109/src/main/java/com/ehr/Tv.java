package com.ehr;

import org.apache.log4j.Logger;

public interface Tv{
	
	public final static Logger LOG = Logger.getLogger(Tv.class);
	
	public void powerOn();
	
	public void powerOff();

	public void volumeUp();
	
	public void volumeDown();
	
}
