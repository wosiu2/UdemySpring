package com.udemy.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortune;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	public String getTeam() {
		return team;
	}
	
	public String getEmail() {
		return email;
	}


	public SwimCoach(FortuneService fortuneService) {
		this.fortune=fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		
		return "SWIM SWIM";
	}

	@Override
	public String getDailyFortune() {

		return fortune.getFortune();
	}

}
