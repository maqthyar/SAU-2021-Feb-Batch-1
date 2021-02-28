package com.au.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class LoggingAspect 
{
	@After("execution(public * getRectangle())")
	public void afterSetName(){
		System.out.println("\"AFTER\" get Rectangle object");
	}
	
	@AfterReturning(pointcut="execution(public String get*(..))", returning="value") 
	   public void afterReturning(String value) throws Throwable 
	    {
	        System.out.println("\"AFTER RETURNING\" advice value " + value);
	       
	    }
	
    @AfterThrowing (pointcut = "execution(public * getName(..))", throwing = "e")
     public void afterThrowing(Exception e) throws Throwable 
     {
         System.out.println("\"AFTER THROWING\" exception  getName() of triangle" + e);
     }
     
 	@Around("execution(public void setTriangle(..))")
 	public void showAroundMessage() {
 		System.out.println("\"AROUND\" Set method Triangle ");
 	}
} 