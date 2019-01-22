package com.udemy.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {

	@Bean
	public FortuneService practiceFortune() {
		return new PracticeFortuneService();
	}
	
	@Bean
	public PracticeCoach practiceCoach() {
		return new PracticeCoach(practiceFortune());
	}
	
}
