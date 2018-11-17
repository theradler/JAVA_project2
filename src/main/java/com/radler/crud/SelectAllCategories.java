package com.radler.crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;


import com.radler.domain.category;

public class SelectAllCategories extends MappingSqlQuery {
	
	private static final String SQL_SELECT_ALL_CATEGORIES = "select ID, NAME from category"; 
	
	public SelectAllCategories(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_CATEGORIES);
	}

	@Override
	protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		category category = new category(); 
		
		category.setId(rs.getInt("ID"));
		category.setName(rs.getString("NAME"));
		
		return category;
		
	}

}
