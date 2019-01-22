package com.wo.springdemo;

public class TrackCoach implements ICoach {
	private FortuneService _fortune;
	

	
	public TrackCoach(FortuneService fortune) {

		System.out.println("Constructor");
		this._fortune = fortune;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it:"+_fortune.GetFortune();
	}

	public void doMyStartUp() {
		System.out.println("Init Stuff");	
	}
	
	public void doMyCleanUp() {
		System.out.println("CleanUp stuff");
	}
	
}
