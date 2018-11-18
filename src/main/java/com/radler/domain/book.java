package com.radler.domain;
import java.io.Serializable; 
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.radler.domain.category;
import com.radler.domain.author;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.SqlResultSetMapping;




@Entity
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name=book.FIND_ALL,
				query="Select  b From book b "),
	@NamedQuery(name=book.FIND_ALL_WITH_AUTHOR_CATEGORY,
				 query="Select distinct b From book b "
				 		+ "left join fetch b.category c "
				 		+ "left join fetch b.author a"
				 ),
	@NamedQuery(name=book.FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID,
				query="Select distinct b From book b "
						+ "left join fetch b.category c "
						+ "left join fetch b.author a "
						+ "where b.id = :id"
			),
	@NamedQuery(name=book.FIND_BOOKS_BY_AUTHOR_ID,
				query="Select distinct b from book b "
						+ "left join fetch b.category c "
						+ "left join fetch b.author a "
						+ "where a.id = :id")
				 		
})
@SqlResultSetMapping(
		name="bookResult",
		entities=@EntityResult(entityClass=book.class))
public class book implements Serializable {
	
	public static final String FIND_ALL = "book.FIND_ALL";
	
	public static final String FIND_ALL_WITH_AUTHOR_CATEGORY = "book.FIND_ALL_WITH_AUTHOR_CATEGORY";
	
	public static final String FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID = "book.FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID";
	
	public static final String FIND_BOOKS_BY_AUTHOR_ID = "book.FIND_BOOKS_BY_AUTHOR_ID";
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private com.radler.domain.category category;
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
	public void setCategory(com.radler.domain.category category) {
		this.category = category;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, CATEGORY_ID: %d,  ISBN: %s, Title: %s, Price: %s",this.id, this.category.getId(), this.isbn, this.title, this.price);
	}
	



	
}
