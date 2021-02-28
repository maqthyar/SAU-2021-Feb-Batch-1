package com.au.aop.service;

import com.au.aop.model.Rectangle;
import com.au.aop.model.Triangle;

public class ShapeService {
	
	private Rectangle rect;
	private Triangle triangle;
	
	public Rectangle getRectangle() {
		return rect;
	}
	public void setRectangle(Rectangle circle) {
		this.rect = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
