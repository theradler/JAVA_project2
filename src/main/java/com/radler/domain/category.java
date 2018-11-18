package com.radler.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table; 


@Entity
@Table(name = "category")
public class category extends AbstractEntity {
	private int id;
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

}
