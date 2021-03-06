package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.*(..))") 
	public void pointcutDAO() { }
	

	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.get*(..))") 
	public void Getter() { }
	
	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.set*(..))") 
	public void Setter() { }
	
	
	@Pointcut("pointcutDAO() && !(Getter() || Setter())")
	public void ApplyNoGetterSetter() { }
	
	@Before("ApplyNoGetterSetter()")
	public void addAccount() {
		System.out.println(getClass() + " @Before Add Account");
	}
	
	@Before("ApplyNoGetterSetter()")
	public void performAnalytics() {
		System.out.println(getClass() + " @Before perform Analytics");
	}
	
}
