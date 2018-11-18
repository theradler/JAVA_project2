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
    	logger.info("Hello World!");
    	logger.info(pubServ.findAllBooksByNativeQuery());
    	logger.info(pubServ.findAllBooks());
    	logger.info(pubServ.findAllBooksWithAuthorAndCategory());
    	logger.info(pubServ.findBookWithAuthorAndCategoryById(1));
    	logger.info(pubServ.findAllBookByAuthorId(1));
    	
    	//Insert New Book
    	book newBook = new book();
    	newBook.setIsbn("2345235325");
    	newBook.setTitle("Fantasia");
    	newBook.setPrice(12.87);
    	
    	author newAuthor = new author();
    	newAuthor.setFIRST_NAME("Jim");
    	newAuthor.setLAST_NAME("Jimmerson");
    	newAuthor.setDescription("Hey its that guy");
    	
    	newBook.addAuthor(newAuthor);
    	newBook.setCategory(pubServ.getCategoryById(1));

    	//pubServ.save(newBook);
    	newBook = pubServ.findBookWithAuthorAndCategoryById(15);
    	pubServ.deleteBook(newBook);

    }
}
