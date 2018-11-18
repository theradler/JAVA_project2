package com.radler.service;
import com.radler.domain.book;
import com.radler.domain.category;
import java.util.List;

public interface PublishingService {
	
	List<book> findAllBooks();
	book findBookWithAuthorAndCategoryById(int id);
	book save(book book);
	void deleteBook(book book);
	

}
