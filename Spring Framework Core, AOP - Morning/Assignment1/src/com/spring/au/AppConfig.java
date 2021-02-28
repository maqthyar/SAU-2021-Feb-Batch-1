package com.spring.au;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig 
{

    @Bean(name="rect")
    public Rectangle getRectangle() 
    {
        return new Rectangle(15,25);
    }

    @Bean(name="a")
    public Point getA() 
    {
        return new Point(0,0);
    }

    @Bean(name="b")
    public Point getB() 
    {
        return new Point(15,0);
    }

    @Bean(name="c")
    public Point getC() 
    {
        return new Point(0,25);
    }

    @Bean(name="d")
    public Point getD() 
    {
        return new Point(15,25);
    }
    
   
}