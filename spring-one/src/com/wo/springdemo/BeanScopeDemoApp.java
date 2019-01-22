package com.wo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		ICoach theCoach = ctx.getBean("myCoach", ICoach.class);
		
		System.out.println(theCoach);
		ICoach secCoach = ctx.getBean("myCoach", ICoach.class);
		System.out.println(secCoach);
		ctx.close();
	}

}
