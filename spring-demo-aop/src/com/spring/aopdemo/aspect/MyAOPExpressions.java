package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAOPExpressions {

	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {
	};
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	private void setter() {};
	
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	private void getter() {};
	
	@Pointcut("forDAOPackage()&& !setter() && !getter()")
	public void forDAOPackageNoGetterSetter() {};
}
