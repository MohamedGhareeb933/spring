package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpression {

	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.*(..))") 
	public void pointcutDAO() { }
	

	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.get*(..))") 
	public void getter() { }
	
	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.set*(..))") 
	public void setter() { }
	
	
	@Pointcut("pointcutDAO() && !(getter() || setter())")
	public void ApplyNoGetterSetter() { }
	
	
}
