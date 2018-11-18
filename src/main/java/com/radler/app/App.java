package com.radler.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.radler.dao.PublishDao;
import com.radler.config.AppConfig;


import com.radler.domain.book; 


public class App 
{
    public static void main( String[] args )
    {
    	
    	GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
    	PublishDao publishDao = context.getBean(PublishDao.class);
    	System.out.println(publishDao.findAllBooksWithoutAuthorAndCategories());
        System.out.println( "Hello World!" );
    }
}
