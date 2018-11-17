package com.radler.dao;

import com.radler.domain.book;
import com.radler.domain.category;
import java.util.List; 

public interface BookDao {
	
	public List<book> findAllBooks();
	public List<category> findAllCategories(); 
	public List<book> findAllByCategory(String categoryName); 
	public void insertBook(book book); 
	public void updateBook(book book); 
	public void deleteBook(book book);
	

}
