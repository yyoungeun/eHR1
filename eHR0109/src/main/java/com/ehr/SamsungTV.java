package com.ehr;

public class SamsungTV implements Tv {
	
	private String brandNm="SamsungTV";
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		
	}
	
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
		LOG.info("================================");
		LOG.info(brandNm+"SamsugTV생성자---speaker"+ speaker);
		LOG.info(brandNm+"SamsugTV생성자---price"+ price);
		LOG.info("================================");
	}

	public void destroyMethod() {
		LOG.info("================================");
		LOG.info(brandNm+"destroyMethod---객체 반환");
		LOG.info("================================");
	}
	
	public void initMethod() {
		LOG.info("================================");
		LOG.info(brandNm+"initMethod---초기화");
		LOG.info("================================");
	}

	@Override
	public void powerOn() {
		LOG.info("================================");
		LOG.info(brandNm+"powerOn---전원을 켠다.");
		LOG.info("================================");

	}

	@Override
	public void powerOff() {
		LOG.info("================================");
		LOG.info(brandNm+"powerOn---전원을 끈다.");
		LOG.info("================================");
	}

	@Override
	public void volumeUp() {
		LOG.info("================================");
		//speaker.volumeUp(); //AppleSpeaker.java
		LOG.info(brandNm+"volumeDown---볼륨을 높인다.");
		LOG.info("================================");

	}

	@Override
	public void volumeDown() {
		LOG.info("================================");
		speaker.volumeDown();
		//LOG.info(brandNm+"volumeDown---볼륨을 낮춘다.");
		LOG.info("================================");

	}

}
