package com.udemy.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${foo.data}")
	private String[] data;
	private Random rand=new Random();
	
	@Override
	public String getFortune() {

		return data[rand.nextInt(data.length)];
	}

}
