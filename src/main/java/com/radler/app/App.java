package com.radler.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.radler.config.AppConfig;


import com.radler.domain.book; 


public class App 
{
    public static void main( String[] args )
    {
    	
    	GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
    	
        System.out.println( "Hello World!" );
    }
}
