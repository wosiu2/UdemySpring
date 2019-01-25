package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount(new Account("WW", "1"), true);

		accountDAO.addAccount(new Account("WW","1"),true);
		System.out.println("...............................................");
		try {
			System.out.println(accountDAO.findAccounts(false));
		} catch (Exception e) {

			e.printStackTrace();
		}
		context.close();
	}

}
