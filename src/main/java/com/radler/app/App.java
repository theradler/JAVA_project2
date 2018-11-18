package com.radler.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.radler.dao.PublishDao;
import com.radler.config.AppConfig;


import com.radler.domain.book; 
import com.radler.domain.category;
import com.radler.domain.author;


public class App 
{
    public static void main( String[] args )
    {
    	
    	GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
    	PublishDao publishDao = context.getBean(PublishDao.class);
    	System.out.println(publishDao.findAllBooksWithoutAuthorAndCategories());
    	System.out.println(publishDao.findAllBooksWithAuthorAndCategories());
    	System.out.println(publishDao.findBookWithAuthorAndCategoryByBookId(1));
    	
    	book newBook = new book();
    	newBook.setIsbn("12345");
    	newBook.setTitle("Spooky House 2");
    	newBook.setPrice(12.99);
    	//category newCategory = new category();
    	//newCategory.setName("JAVA");
    	category cat = publishDao.getCategoryById(1); 
    	newBook.setCategory(cat);
    	author newAuthor = new author();
    	newAuthor.setFIRST_NAME("Greg");
    	newAuthor.setLAST_NAME("Greggerson");
    	newAuthor.setDescription("Its new old Greg");
    	newBook.addAuthor(newAuthor);
    	publishDao.addBook(newBook);
        System.out.println( "Hello World!" );
    }
}
