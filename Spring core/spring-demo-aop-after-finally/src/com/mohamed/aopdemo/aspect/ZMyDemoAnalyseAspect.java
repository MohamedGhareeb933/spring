package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class ZMyDemoAnalyseAspect {

	@Before("com.mohamed.aopdemo.aspect.AOPExpression.ApplyNoGetterSetter()")
	public void performAnalytics() {
		System.out.println("@Before perform Analytics");
	}
	
}
