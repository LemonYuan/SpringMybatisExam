package com.hand.SpringMybatisExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringMybatisExam.service.CustomerService;

public class App2 {
	
	    public static void main( String[] args )
	    {
	    	ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    	CustomerService customerService=(CustomerService) context.getBean("customerService");
	    	customerService.deleteCustomer();
	    }
	}
