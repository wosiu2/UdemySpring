package com.wo.springdemo;

import java.util.Random;

public class NewFortuneService implements FortuneService {

	private String[] fortunes;/*=new String[] {
			"ABCDEF",
			"QWERTYT",
			"ZXCVB"
	};*/
	
	public void setFortunes(String[] fortunes) {
		this.fortunes = fortunes;
	}

	@Override
	public String GetFortune() {
		Random rand=new Random();

		return fortunes[rand.nextInt(3)];
	}

}
