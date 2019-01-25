package com.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String level;
	
	public void addAccount() {
		System.out.println("Account processing");
	}
	
	public void addAccount(Account account,boolean isVip) {
		System.out.println("Account processing");
	}

	public List<Account> findAccounts(boolean withException) throws Exception{
		
		if(withException) {
			System.out.println("I am throwing exception");
			throw new Exception();
		}
		
		var accounts=new ArrayList<Account>();
		
		accounts.add(new Account("abc","cba"));
		accounts.add(new Account("cba","abc"));
		accounts.add(new Account("qwer","asd"));
		
		return accounts;
	}
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		System.out.println("Geting level");
		return level;
	}

	public void setLevel(String level) {
		System.out.println("seting level");
		this.level = level;
	}
	
	
}
