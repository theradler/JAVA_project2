package com.radler.domain;
import java.io.Serializable; 
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.radler.domain.category;
import com.radler.domain.author;



@Entity(name = "book")
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name=book.findAllBooksWithoutAuthorAndCategories,
				query="Select id, category, isbn, title, price FROM book "
						)
})
public class book implements Serializable {
	
	public static final String findAllBooksWithoutAuthorAndCategories = "book.findAllBooksWithoutAuthorAndCategories";
	
	@Id
	@Column(name = "BOOK_ID")
	private int id;
	@Column(name = "CATEGORY_ID")
	private category category;
	@Column(name = "ISBN")
	private String isbn;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "PRICE")
	private double price;
	@OneToOne
	@JoinTable(name="author_book",
				joinColumns=@JoinColumn(name="BOOK_ID"),
				inverseJoinColumns=@JoinColumn(name="AUTHOR_ID")		
			)
	private author author;
	
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
	@ManyToOne
	@JoinColumn(name="category")
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public author getAuthor() {
		return author;
	}
	public void setAuthor(author author) {
		this.author = author;
	}


}
