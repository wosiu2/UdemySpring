package com.udemy.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DataBeseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "DB fortune";
	}

}
