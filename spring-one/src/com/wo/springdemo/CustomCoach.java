package com.wo.springdemo;

public class CustomCoach implements ICoach {
	
	private FortuneService _fortune;
	
	public CustomCoach(FortuneService theFortuneService) {
		_fortune=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "More pushups!";
	}

	@Override
	public String getDailyFortune() {
		
		return _fortune.GetFortune();
	}

}
