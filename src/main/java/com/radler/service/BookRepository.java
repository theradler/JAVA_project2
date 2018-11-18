package com.radler.service;
import java.util.List;

import com.radler.domain.book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<book, Long>{
	book findByid(Long id); 
	List<book> findAll();
	void delete(book book); 
	book save(book book); 
	
	
}
