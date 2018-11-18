package com.radler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

import com.radler.domain.book;

@Transactional
@Repository("publishDao")
public class PublishDaoImp implements PublishDao {
	
	private SessionFactory sessionFactory;

	public List<book> findAllBooksWithoutAuthorAndCategories() {
		return sessionFactory.getCurrentSession().getNamedQuery("book.findAllBooksWithoutAuthorAndCategories").list();
	}

	public List<book> findAllBooksWithAuthorAndCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<book> findBookWithAuthorAndCategoryByBookID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Resource(name= "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}

}
