package com.ehr;

public class LgTV implements Tv {
	
	private String brandNm="LgTV";

	@Override
	public void powerOn() {
		LOG.debug("================================");
		LOG.debug(brandNm+"powerOn---전원을 켠다.");
		LOG.debug("================================");

	}

	@Override
	public void powerOff() {
		LOG.debug("================================");
		LOG.debug(brandNm+"powerOn---전원을 끈다.");
		LOG.debug("================================");
	}

	@Override
	public void volumeUp() {
		LOG.debug("================================");
		LOG.debug(brandNm+"volumeUp---볼륨을 높인다.");
		LOG.debug("================================");

	}

	@Override
	public void volumeDown() {
		LOG.debug("================================");
		LOG.debug(brandNm+"volumeDown---볼륨을 낮춘다.");
		LOG.debug("================================");

	}

}
