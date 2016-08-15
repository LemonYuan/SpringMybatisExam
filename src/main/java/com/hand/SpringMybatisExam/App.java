package com.hand.SpringMybatisExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringMybatisExam.service.CustomerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	CustomerService customerService=(CustomerService) context.getBean("customerService");
    	customerService.insert(); 	

    }
}
