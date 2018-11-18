package com.radler.domain;
import java.io.Serializable; 
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.radler.domain.category;
import com.radler.domain.author;




@Entity
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name=book.findAllBooksWithoutAuthorAndCategories,
				query="Select distinct b From book b"),
	@NamedQuery(name=book.findAllBooksWithAuthorAndCategories,
				 query="Select distinct b From book b "
				 		+ "left join fetch b.category c "
				 		+ "left join fetch b.author a"
				 ),
	@NamedQuery(name=book.findBookWithAuthorAndCategoryByBookId,
				query="Select distinct b From book b "
						+ "left join fetch b.category c "
						+ "left join fetch b.author a "
						+ "where b.id = :id"
			)
				 		
})
public class book extends AbstractEntity {
	
	public static final String findAllBooksWithoutAuthorAndCategories = "book.findAllBooksWithoutAuthorAndCategories";
	
	public static final String findAllBooksWithAuthorAndCategories = "book.findAllBooksWithAuthorAndCategories";
	
	public static final String findBookWithAuthorAndCategoryByBookId = "book.findBookWithAuthorAndCategoryByBookId";

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORY_ID")
	private category category;
	@Column(name = "ISBN")
	private String isbn;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "PRICE")
	private double price;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="author_book",
				joinColumns=@JoinColumn(name="BOOK_ID"),
				inverseJoinColumns=@JoinColumn(name="AUTHOR_ID")		
			)
	private Set<author> author = new HashSet<com.radler.domain.author>();
	
	public Set<author> getAuthor() {
		return this.author;
	}

	public void setAuthor(Set<author> author) {
		this.author = author;
	}
	
	public void addAuthor(author author) {
		this.author.add(author);
	}
	
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
	@JoinColumn(name="CATEGORY_ID")
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, CATEGORY_ID: %d,  ISBN: %s, Title: %s, Price: %s",this.id, this.category.getId(), this.isbn, this.title, this.price);
	}


	
}
