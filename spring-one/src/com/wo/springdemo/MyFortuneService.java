package com.wo.springdemo;

public class MyFortuneService implements FortuneService {

	@Override
	public String GetFortune() {
		return "Today is your lucky day!";
	}

}
