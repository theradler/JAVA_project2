package com.radler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

import com.radler.domain.author;
import com.radler.domain.book;
import com.radler.domain.category;

@Transactional
@Repository("publishDao")
public class PublishDaoImp implements PublishDao {
	
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	public List<book> findAllBooksWithoutAuthorAndCategories() {
		return sessionFactory.getCurrentSession().getNamedQuery("book.findAllBooksWithoutAuthorAndCategories").list();
	}
	@Transactional(readOnly=true)
	public List<book> findAllBooksWithAuthorAndCategories() {
		return sessionFactory.getCurrentSession().getNamedQuery("book.findAllBooksWithAuthorAndCategories").list();
	}
	@Transactional(readOnly=true)
	public List<book> findBookWithAuthorAndCategoryByBookId(int id) {
		return (List<book>) sessionFactory.getCurrentSession().getNamedQuery("book.findBookWithAuthorAndCategoryByBookId").setParameter("id", id).list();
		
	}
	
	@Resource(name= "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	public book addBook(book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		return book;
	}
	public category getCategoryById(int id) {
		return (category) sessionFactory.getCurrentSession().getNamedQuery("category.getCategoryById").setParameter("id", id).uniqueResult(); 
	}
	public author getAuthorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<book> getBooksByAuthor(author author) {
		// TODO Auto-generated method stub
		return null;
	}

}
