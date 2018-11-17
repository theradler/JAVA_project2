package com.radler.crud;

import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.ResultSet;
import java.sql.Types;

import javax.sql.DataSource;

import java.sql.SQLException;

import com.radler.domain.book;
import com.radler.domain.category;

public class FindAllByCategory extends MappingSqlQuery<book> {
	
	private static final String SQL_FIND_BOOK_BY_CATEGORY = "select id, category_id, isbn, title, price from book where category_id = (SELECT ID FROM category where Name = :name)";
	
	public FindAllByCategory(DataSource dataSource) {
		super(dataSource, SQL_FIND_BOOK_BY_CATEGORY);
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
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
