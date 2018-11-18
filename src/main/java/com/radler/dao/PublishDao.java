package com.radler.dao;
import java.util.List;

import com.radler.domain.book;
import com.radler.domain.category;
import com.radler.domain.author;
public interface PublishDao {

	List<book> findAllBooksWithoutAuthorAndCategories();
	List<book> findAllBooksWithAuthorAndCategories();
	List<book> findBookWithAuthorAndCategoryByBookId(int id); 
	book addBook(book book); 
	category getCategoryById(int id);
	author getAuthorById(int id);
	List<book> getBooksByAuthor(author author);
	
}
