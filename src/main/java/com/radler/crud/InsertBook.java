package com.radler.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBook extends SqlUpdate {
	
	private static final String SQL_INSERT_BOOK =  "insert into book (category_id, isbn, title, price) VALUES (:category_id, :isbn, :title, :price)";
	
	public InsertBook(DataSource dataSource) {
		super(dataSource, SQL_INSERT_BOOK);
		super.declareParameter(new SqlParameter("category_id", Types.INTEGER));
		super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
		super.declareParameter(new SqlParameter("title", Types.VARCHAR));
		super.declareParameter(new SqlParameter("price", Types.DECIMAL)); 
	}

}
