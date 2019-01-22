package com.udemy.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DifferentCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Different training";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
