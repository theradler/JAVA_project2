package com.radler.dao;
import java.util.List;

import com.radler.domain.*;

public interface PublishDao {

	List<book> findAllBooksWithoutAuthorAndCategories();
	List<book> findAllBooksWithAuthorAndCategory();
	List<book> findBookWithAuthorAndCategoryByBookID(int id); 
	
}
