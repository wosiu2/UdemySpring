package com.wo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");	
		ICoach theCoach=ctx.getBean("myCoach",ICoach.class);
		ICoach alphaCoach=ctx.getBean("myCoach",ICoach.class);
		
		
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		ctx.close();
	}

}
