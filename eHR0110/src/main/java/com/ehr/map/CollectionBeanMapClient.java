package com.ehr.map;



import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanMapClient {

	static final Logger LOG = Logger.getLogger(CollectionBeanMapClient.class);
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContextMap.xml");
		
		LOG.info("context: " + context);
		CollectionBeanMap colMap = (CollectionBeanMap) context.getBean("collectionBeanMap");
		
		LOG.info("02.colMap:" + colMap);
		
		Map<String,String> map = colMap.getAddressMap(); //data가져오기(get)
		Set<String> set = map.keySet(); //key값 가져오기
		
		for(String key : set) {
			LOG.info("03.addr: " + key + "=" + map.get(key));
		}

	}

}
