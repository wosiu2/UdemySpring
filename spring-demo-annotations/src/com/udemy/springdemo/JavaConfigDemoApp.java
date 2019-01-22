package com.udemy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(PracticeSportConfig.class);
	
		PracticeCoach theCoach=ctx.getBean("practiceCoach",PracticeCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
	
		System.out.println(theCoach.getDailyFortune());

		
		ctx.close();
	}

}
