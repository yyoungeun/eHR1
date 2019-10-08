package com.ehr;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvClient02 {

	static final Logger LOG = Logger.getLogger(TvClient02.class);
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext02.xml");
		LOG.debug("=============================");
		LOG.debug("context=" + context);
		LOG.debug("=============================");
		
		Tv tv = context.getBean("samsungTV", SamsungTV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
