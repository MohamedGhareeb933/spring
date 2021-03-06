package com.mohamed.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohamed.aopdemo.service.FortuneService;


public class ArroundWithLoggerAppDemo {
	
	private static  Logger logger = Logger.getLogger(ArroundWithLoggerAppDemo.class.getName());
	
	public static void main( String[] args) {
		
		AnnotationConfigApplicationContext Context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		FortuneService fortuneService = Context.getBean("fortuneService", FortuneService.class);
		
		logger.info("Main App: Arround - Calling getFortuneService ");
		
		logger.info(fortuneService.getFortuneService());
		
		Context.close();
		
	}

}
