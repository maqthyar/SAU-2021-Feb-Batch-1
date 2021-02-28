package com.au.aop.model;

public class Triangle {
	
	private String name;

	public void getName() throws Exception {
		
		System.out.println("Name of triangle is " + name);
		throw new NullPointerException();
	
	}

	public void setName(String name) {
		this.name = name;
	}

}
