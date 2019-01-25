package com.spring.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger=
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService fortuneService=
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info(fortuneService.getFortune());
		
		context.close();
	}

}
