package com.wo.springdemo;

public class MyApp {

	public static void main(String[] args) {
		ICoach theCoach=new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkout());

	}

}
