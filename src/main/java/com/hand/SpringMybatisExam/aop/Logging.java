package com.hand.SpringMybatisExam.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	@Pointcut("execution(* com.hand.SpringMybatisExam.service.CustomerServiceImpl.insert(..))")
	private void selectAll(){}
	
	
	@Before("selectAll()") 
   public void doBefore()
   {
	   System.out.println("=====before inser customer data=====");
   }
	
	@After("selectAll()") 
   public void doAfter()
   {
	   System.out.println("=====after inser customer data=====");
   }
}
