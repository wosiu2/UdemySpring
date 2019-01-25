package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
	
	@Before("com.spring.aopdemo.aspect.MyAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("Before adding account ............");
	}
	
	@Before("com.spring.aopdemo.aspect.MyAOPExpressions.forDAOPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("Async logging to Cloud.....");
	}
}
