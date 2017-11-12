package hu.gaborbalazs.practice.jsf.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.gaborbalazs.practice.ejb.BookEjb;
import hu.gaborbalazs.practice.entity.Book;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Named
@RequestScoped
public class BookBacking {

	public class PriceChanger {

		private Long id = 1L;
		private Float price = 100f;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}
	}

	@Inject
	private BookEjb bookEJB;

	private PriceChanger priceChanger = new PriceChanger();
	private Book book = new Book();
	private List<Book> bookList = new ArrayList<>();

	public BookBacking() {
	}

	public String doCreateBook() {
		book = bookEJB.createBook(book);
		bookList = bookEJB.findBooks();
		return "listBooks.xhtml";
	}

	public String updateBook() {
		Book book = bookEJB.findById(priceChanger.getId());
		book.setPrice(book.getPrice() + priceChanger.getPrice());
		bookEJB.save(book);
		return "listBooks.xhtml";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		bookList = bookEJB.findBooks();
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public PriceChanger getPriceChanger() {
		return priceChanger;
	}

	public void setPriceChanger(PriceChanger priceChanger) {
		this.priceChanger = priceChanger;
	}
}
