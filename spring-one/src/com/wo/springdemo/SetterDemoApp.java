package com.wo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CricketCoach theCoach=ctx.getBean("myCricketCoach",CricketCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmailAdress());
		System.out.println(theCoach.getTeam());
		ctx.close();

	}

}
