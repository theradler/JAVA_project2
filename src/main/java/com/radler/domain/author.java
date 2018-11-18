package com.radler.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


import com.radler.domain.book;
@Entity
@Table(name= "author")
public class author extends AbstractEntity {


	private String FIRST_NAME;
	private String LAST_NAME;
	private String Description;
	@OneToMany
	@JoinTable(name="author_book",
			   joinColumns=@JoinColumn(name="AUTHOR_ID"),
			   inverseJoinColumns=@JoinColumn(name="BOOK_ID")
			)
	private Set<book> book;
	

	public String getFIRST_NAME() {
		return this.FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		this.FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return this.LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		this.LAST_NAME = lAST_NAME;
	}
	public String getDescription() {
		return this.Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}

	public Set<book> getBook() {
		return this.book;
	}

	public void setBook(Set<book> book) {
		this.book = book;
	}
	
	

	
	
	
	
}
