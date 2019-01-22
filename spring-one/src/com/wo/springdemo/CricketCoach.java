package com.wo.springdemo;

public class CricketCoach implements ICoach {
	private FortuneService fortuneService; 
	private String emailAdress;
	private String team;
	
	public String getEmailAdress() {
		return emailAdress;
	}

	public String getTeam() {
		return team;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling fir 15 min";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.GetFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	

}
