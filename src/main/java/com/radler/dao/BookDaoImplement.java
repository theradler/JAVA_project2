package com.radler.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;


import com.radler.domain.book;
import com.radler.domain.category;
import com.radler.crud.*;

@Repository("bookDao")
public class BookDaoImplement implements BookDao {
	
	private static Logger logger = LoggerFactory.getLogger(BookDaoImplement.class); 
	private DataSource dataSource;
	private SelectAllBooks findAllBooks; 
	private SelectAllCategories findAllCategories; 
	private FindAllByCategory findAllByCategory;
	private InsertBook insertBook;
	private UpdateBook updateBook;
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("Problem Loading JDBC Driver", e);
		}
	}	

	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.findAllBooks = new SelectAllBooks(dataSource);
		this.findAllCategories = new SelectAllCategories(dataSource); 
		this.findAllByCategory = new FindAllByCategory(dataSource); 
		this.insertBook = new InsertBook(dataSource); 
		this.updateBook = new UpdateBook(dataSource);
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}


	public List<book> findAllBooks() {
		return findAllBooks.execute(); 
	}


	public List<category> findAllCategories() {
		return findAllCategories.execute();
	}


	public List<book> findAllByCategory(String categoryName) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); 
		paramMap.put("name", categoryName); 
		return findAllByCategory.executeByNamedParam(paramMap);
	}


	public void insertBook(book book) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category_id", book.getCategory_Id());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("title", book.getTitle()); 
		paramMap.put("price", book.getPrice());
		insertBook.updateByNamedParam(paramMap); 
		
	}


	public void updateBook(book book) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category_id", book.getCategory_Id());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("title", book.getTitle()); 
		paramMap.put("price", book.getPrice());
		paramMap.put("id", book.getId());
		updateBook.updateByNamedParam(paramMap); 
		
	}


	public void deleteBook(book book) {
		// TODO Auto-generated method stub
		
	}

}
