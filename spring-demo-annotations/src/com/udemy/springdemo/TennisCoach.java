package com.udemy.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {


	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	public void initMethod() {
		
		System.out.println("Init method");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Tennis training for 15 min";
	}
	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
