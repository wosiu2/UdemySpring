package com.udemy.springdemo;

public class PracticeCoach implements Coach {
	private FortuneService fortune;

	public PracticeCoach(FortuneService fortune) {
		this.fortune=fortune;
	}
	
	@Override
	public String getDailyWorkout() {

		return "Practice workout";
	}

	@Override
	public String getDailyFortune() {

		return fortune.getFortune();
	}

}
