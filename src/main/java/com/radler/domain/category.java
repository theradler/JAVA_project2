package com.radler.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table; 


@Entity
@Table(name = "category")
@NamedQueries({
	@NamedQuery(name=category.getCategoryById,
				query="Select distinct c From category c where c.id = :id"),
				 		
})
public class category extends AbstractEntity {

	public static final String getCategoryById = "category.getCategoryById";
	
	@Column(name="NAME")
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(mappedBy ="category")
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override public String toString() {
		return String.format("Category Name: %s", this.name);
	}

}
