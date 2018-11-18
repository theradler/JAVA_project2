package com.radler.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.radler.app.App;
import com.radler.domain.book;
import com.radler.domain.category;

@Service("jpaSingerService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PublishingServiceImp implements PublishingService {
	
	private static final Logger logger = LogManager.getLogger(PublishingServiceImp.class.getName());
	
	final static  String ALL_BOOK_NATIVE_QUERY = "select id, category_id, isbn, title, price from book";
	
	
	
	@PersistenceContext
	private EntityManager em; 

	@Transactional(readOnly=true)
	public List<book> findAllBooks() {
		return em.createNamedQuery(book.FIND_ALL, book.class).getResultList();
	}
	@Transactional(readOnly=true)
	public List<book> findAllBooksWithAuthorAndCategory() {
		return em.createNamedQuery(book.FIND_ALL_WITH_AUTHOR_CATEGORY, book.class).getResultList();

	}
	@Transactional(readOnly=true)
	public book findBookWithAuthorAndCategoryById(int id) {
		TypedQuery<book> query = em.createNamedQuery(book.FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID, book.class);
		query.setParameter("id",id);
		return query.getSingleResult();
	}

	public book save(book book) {
		if (book.getId() == 0) {
			logger.info("Inserting new book");
			em.persist(book);
		} else {
			em.merge(book);
			logger.info("Updating existing book");
		}
		logger.info("Book saved ith id: " + book.getId());
		return book;
	}

	public void deleteBook(book book) {
		logger.info(book.getId());
		book mergeContact = em.merge(book);
		em.remove(mergeContact);
		logger.info("Book with Id: " + book.getId() + " removed from db"); 
		
	}

	public List<book> findAllBookByAuthorId(int id) {
		TypedQuery<book> query = em.createNamedQuery(book.FIND_BOOKS_BY_AUTHOR_ID, book.class);
		query.setParameter("id", id);
		return  query.getResultList();
	}

	public List<book> findAllBooksByNativeQuery() {
		return em.createNativeQuery(ALL_BOOK_NATIVE_QUERY, "bookResult").getResultList();
	}
	public category getCategoryById(int id) {
		TypedQuery<category> query = em.createNamedQuery(category.getCategoryById, category.class);
		query.setParameter("id",id);
		return query.getSingleResult();
	}

}
