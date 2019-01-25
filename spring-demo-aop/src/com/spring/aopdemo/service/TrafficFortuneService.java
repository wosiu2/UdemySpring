package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ssssssssssssssssssssssssssssss";
	}

	public String getFortune(boolean b){
		
		if(b) throw new RuntimeException("Accident");
		return "heavy traffic ....";
	}
}
