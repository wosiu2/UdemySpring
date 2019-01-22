package com.wo.springdemo;

public class BasballCoach implements ICoach{
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minuntes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
}
