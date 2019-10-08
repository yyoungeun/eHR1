package com.ehr;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvClient {

	static final Logger LOG = Logger.getLogger(TvClient.class);
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		LOG.debug("=============================");
		LOG.debug("context=" + context);
		LOG.debug("=============================");

	}

}
