package com.mohamed.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohamed.aopdemo.service.FortuneService;


public class ArroundAppDemo {
	public static void main( String[] args) {
		
		AnnotationConfigApplicationContext Context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		
		FortuneService fortuneService = Context.getBean("fortuneService", FortuneService.class);
		
		System.out.println("Main App: Arround - Calling getFortuneService ");
		
		System.out.println(fortuneService.getFortuneService());
		
		Context.close();
		
	}

}
