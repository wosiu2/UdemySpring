package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService fortuneService=
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println(fortuneService.getFortune());
		
		context.close();
	}

}
