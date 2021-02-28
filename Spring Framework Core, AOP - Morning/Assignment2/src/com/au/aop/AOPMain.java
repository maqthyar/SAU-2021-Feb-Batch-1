package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.model.Triangle;
import com.au.aop.service.ShapeService;

public class AOPMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		System.out.println("Rectangle Name "+shapeService.getRectangle().getName());
		
		Triangle t = ctx.getBean(Triangle.class); 
		shapeService.setTriangle(t);
		
		try {
		t.getName();
		}
		catch(Exception e)
		{
			
		}
		
	}

}
