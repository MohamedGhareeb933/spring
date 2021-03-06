package com.luv2code.springdemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.luv2code.springdemo")
@PropertySource({ "classpath:application.properties" })
public class DemoAppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		
		try {
			// set DB Driver
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}catch(Exception Exc) {
			
		}
		
		// set JDBC property
		myDataSource.setJdbcUrl(env.getProperty("dbc.url)"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		
		// set Connection Property
		myDataSource.setInitialPoolSize(parseInt("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(parseInt("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(parseInt("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(parseInt("connection.pool.maxIdleTime"));
		
		return myDataSource;
	}
	
	// helper Class that Convert/map Strings val into int
	private int parseInt(String propName) {
		return Integer.parseInt(env.getProperty(propName));
	}
	
	private Properties HibernateProperties() {
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean factoryBean() {
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(myDataSource());
		factoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		factoryBean.setHibernateProperties(HibernateProperties());
		
		return factoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransaction(SessionFactory SessionFactory) {
		
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(SessionFactory);
		
		return htm;
	}
	
	
	// define bean for RestTemplate ... this is used to make client REST calls
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// add resource handler for loading css, images, etc
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
}









