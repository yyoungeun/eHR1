package com.ehr;

import org.apache.log4j.Logger;

public class AppleSpeaker implements Speaker {
	

	private String brandNm = "AppleSpeaker";
	
	public AppleSpeaker() {
		LOG.info("================================");
		LOG.info(brandNm+"**SonySpeaker---생성자");
		LOG.info("================================");
	}
	@Override
	public void volumeUp() {
		LOG.info("================================");
		LOG.info(brandNm+"volumeUp---소리를 올린다.");
		LOG.info("================================");
	}

	@Override
	public void volumeDown() {
		LOG.info("================================");
		LOG.info(brandNm+"volumeDown---소리를 낮춘다.");
		LOG.info("================================");
	}

}
