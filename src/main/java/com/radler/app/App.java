package com.radler.app;



import com.radler.domain.book; 
import com.radler.domain.category;
import com.radler.domain.author;
import com.radler.service.PublishingService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;


public class App 
{
	private static final Logger logger = LogManager.getLogger(App.class.getName());
    public static void main( String[] args )
    {
    	GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    	context.load("classpath:spring/app-context.xml");
    	context.refresh();
    	PublishingService pubServ = context.getBean(PublishingService.class);
    	logger.info(pubServ.findAllBooks());
    	

    	//pubServ.save(newBook);
    	//newBook = pubServ.findBookWithAuthorAndCategoryById(15);
    	//pubServ.deleteBook(newBook);

    }
}
