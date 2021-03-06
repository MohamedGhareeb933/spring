package com.mohamed.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.mohamed.springdemo.controller.*.*(..) )")
	private void ControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.mohamed.springdemo.service.*.*(..) )")
	private void ServicePackage() {
		
	}
	
	@Pointcut("execution(* com.mohamed.springdemo.dao.*.*(..) )")
	private void DAOPackage() {
		
	}
	
	@Pointcut("ControllerPackage() || ServicePackage() || DAOPackage() ")
	private void AppFlow() {
		
	}
	
	@Before("AppFlow()")
	public void Before(JoinPoint joinPoint) {
		String Method = joinPoint.getSignature().toString();
		
		// get the Method That being called
		logger.info("@Before Advice: " + Method);
	
		// get the Arguments of the Method. 
		Object args[] = joinPoint.getArgs();
		//iterate through Arguments
		for	(Object a : args) {
			logger.info( "Argument: " + a.toString());
		}
	}
	
	@AfterReturning(
			pointcut="AppFlow()",
			returning="result")
	public void AfterReturning(JoinPoint joinPoint, Object result) {
		
		// display the Method Returning from 
		String method = joinPoint.getSignature().toString();
		
		logger.info("@AfterReturning Method :" + method);
		
		// display the Return 
		logger.info("@AfterReturning Return :" + result);
	}
	
}
