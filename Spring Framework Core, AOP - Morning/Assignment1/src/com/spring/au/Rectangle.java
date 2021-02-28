package com.spring.au;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.au.Point;;

@Component
@Scope(value = "prototype")
public class Rectangle 
{

    @Autowired
    @Qualifier("a")
    Point a;

    @Autowired
    @Qualifier("b")
    Point b;

    @Autowired
    @Qualifier("c")
    Point c;

    @Autowired
    @Qualifier("d")
    Point d;
    

    public Rectangle(int h, int w) {
		super();
		this.h = h;
		this.w = w;
	}



	public Point getA() {
		return a;
	}



	public void setA(Point a) {
		this.a = a;
	}



	public Point getB() {
		return b;
	}



	public void setB(Point b) {
		this.b = b;
	}



	public Point getC() {
		return c;
	}



	public void setC(Point c) {
		this.c = c;
	}



	public Point getD() {
		return d;
	}



	public void setD(Point d) {
		this.d = d;
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}



	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	int h;
    int w;
    
    

    public void draw() 
    {
        System.out.println("Rectangle height =  "+getH()+" and width = "+getW());
        
        System.out.println();
        
        System.out.println("Points");
        
        System.out.println("A = ("+a.getX()+","+a.getY()+")");
        System.out.println("B = ("+b.getX()+","+b.getY()+")");
        
        System.out.println("C = ("+c.getX()+","+c.getY()+")");
        
        System.out.println("D = ("+d.getX()+","+d.getY()+")");
        
 
    }
}
