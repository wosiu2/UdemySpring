package com.udemy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigPracticeApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(SportConfig.class);
	
		SwimCoach theCoach=ctx.getBean("swimCoach",SwimCoach.class);
		//Coach alphaCoach=ctx.getBean("swimmCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
	
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		ctx.close();
	}

}
