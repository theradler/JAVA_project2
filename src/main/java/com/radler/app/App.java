package com.radler.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.radler.config.AppConfig;
import com.radler.dao.BookDaoImplement;

import com.radler.domain.book; 


public class App 
{
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
    	BookDaoImplement bookDao = context.getBean("bookDao", BookDaoImplement.class);
    	System.out.println(bookDao.getDataSource());
    	System.out.println(bookDao.findAllBooks());
    	System.out.println(bookDao.findAllByCategory("Horror"));
    	
    	book newBook = new book(); 
    	newBook.setCategory_Id(1);
    	newBook.setIsbn("97815011");
    	newBook.setTitle("NOT IT");
    	newBook.setPrice(15.99);
    	newBook.setId(11);
    	//bookDao.insertBook(newBook);
    	
    	bookDao.updateBook(newBook);
    	
        System.out.println( "Hello World!" );
    }
}
