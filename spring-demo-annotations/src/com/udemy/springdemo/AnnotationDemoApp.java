package com.udemy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach=ctx.getBean("tennisCoach",Coach.class);
		Coach alphaCoach=ctx.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
	
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		
		ctx.close();
	}

}
