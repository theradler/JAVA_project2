package com.radler.crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.radler.domain.book;

public class SelectAllBooks extends MappingSqlQuery<book> {

	private static final String SQL_SELECT_ALL_BOOKS = "SELECT ID, CATEGORY_ID, ISBN, TITLE, PRICE FROM book"; 
	
	public SelectAllBooks(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_BOOKS);
	}
	
	@Override
	protected book mapRow(ResultSet rs, int rowNum) throws SQLException {
		book book = new book();
		
		book.setId(rs.getInt("ID"));
		book.setCategory_Id(rs.getInt("CATEGORY_ID"));
		book.setIsbn(rs.getString("ISBN"));
		book.setTitle(rs.getString("TITLE"));
		book.setPrice(rs.getDouble("PRICE"));
		
		return book;
	}

}
