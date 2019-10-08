package com.ehr;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvClient02 {

	static final Logger LOG = Logger.getLogger(TvClient02.class);
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext02.xml");
//		LOG.debug("=============================");
//		LOG.debug("context=" + context);
//		LOG.debug("=============================");
//		
		
		//scope="prototype": 객체는 새로생성된다. 기본은 singleton
		Tv tv = (Tv) context.getBean("samsungTV");
		Tv tv01 = (Tv) context.getBean("samsungTV");
		Tv tv02 = (Tv) context.getBean("samsungTV");
		
		LOG.info("=============================");
		LOG.info("tv=" + tv);
		LOG.info("tv01=" + tv01);
		LOG.info("tv02=" + tv02);
		LOG.info("=============================");
		
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		context.close();

	}

}
