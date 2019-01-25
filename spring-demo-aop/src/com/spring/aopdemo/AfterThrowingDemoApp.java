package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		try {
			
			accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("i have exception");
		} 
		context.close();
	}

}
