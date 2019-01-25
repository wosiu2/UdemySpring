package com.spring.aopdemo.aspect;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;
import com.spring.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	private static Logger myLogger=
			Logger.getLogger("com.spring.aopdemo.aspect.MyLoggingAspect");
	
	@Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pjPoint) throws Throwable {
		
		
		long begin=System.currentTimeMillis();
		
		Object result=null;
		
		try {
			result=pjPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
			result="Acident wie will get you with a helicopter";
		}
		
		long end=System.currentTimeMillis();
		
		long duration=end-begin;
		
		myLogger.info("Duration:"+duration/1000.0);
		return result;
		
	}
	
	
	@Before("com.spring.aopdemo.aspect.MyAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("............Before adding account ............");
		MethodSignature mSig=(MethodSignature)joinPoint.getSignature();
		
		var args=joinPoint.getArgs();
		
		for(var e:args) {
			if(e instanceof Account)myLogger.info(((Account)e).getName());
			
		}
		
		myLogger.info("...............................................");
	}
	
	@AfterReturning(
			pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning="result")
	public void afterFindAcountsAdvice(JoinPoint jPoint,List<Account> result) {
		myLogger.info("....................AFTER.....................");
		
		myLogger.info(result.toString());
		
		if(!result.isEmpty()) {
			convertUpper(result);
		}
		myLogger.info("...............................................");
	}

	private void convertUpper(List<Account> result) {
		for(var acc:result) {
			acc.setName(acc.getName().toUpperCase());
		}
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", 
			throwing="exc")
	public void afterFindAcountsThrowingAdvice(JoinPoint jPoint,Throwable exc) {
		myLogger.info("....................AFTERThrowing.....................");
		
		
		myLogger.info("...............................................");
	}
	
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAcountsAdvice(JoinPoint jPoint) {
		myLogger.info("....................AFTER Finally.....................");
		
		
		myLogger.info("...............................................");
	}

}
