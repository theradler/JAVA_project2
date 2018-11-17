package com.radler.domain;
import java.io.Serializable; 




public class book implements Serializable {
	
	private int id;
	private int Category_Id;
	private String isbn;
	private String title;
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getCategory_Id() {
		return Category_Id;
	}
	public void setCategory_Id(int category_Id) {
		Category_Id = category_Id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
