package com.radler.service;

import java.util.List;
import com.google.common.collect.Lists;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.radler.app.App;
import com.radler.domain.book;
import com.radler.domain.category;

@Service("jpaPublishingService")
@Transactional
public class PublishingServiceImp implements PublishingService {
	
	private static final Logger logger = LogManager.getLogger(PublishingServiceImp.class.getName());
	
	@Autowired
	private BookRepository bookRepository; 

	public List<book> findAllBooks() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	public book findBookWithAuthorAndCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public book save(book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(book book) {
		// TODO Auto-generated method stub
		
	}
	


}
