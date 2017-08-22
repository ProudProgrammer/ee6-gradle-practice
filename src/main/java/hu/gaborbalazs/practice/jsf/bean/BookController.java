package hu.gaborbalazs.practice.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.bean.CDITestBean;
import hu.gaborbalazs.practice.ejb.BookEjb;
import hu.gaborbalazs.practice.entity.Book;

@ManagedBean(name = "bookController")
@RequestScoped
public class BookController {

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
	private Logger logger;

	@Inject
	private CDITestBean cdiTestBean;

	@EJB
	private BookEjb bookEJB;

	private PriceChanger priceChanger = new PriceChanger();
	private Book book = new Book();
	private List<Book> bookList = new ArrayList<>();

	public BookController() {
	}

	public String doCreateBook() {
		logger.debug(">> doCreateBook()");
		book = bookEJB.createBook(book);
		bookList = bookEJB.findBooks();
		logger.debug("<< doCreateBook()");
		return "listBooks.xhtml";
	}

	public String updateBook() {
		logger.debug(">> updateBook()");
		Book book = bookEJB.findById(priceChanger.getId());
		book.setPrice(book.getPrice() + priceChanger.getPrice());
		bookEJB.save(book);
		logger.debug("<< updateBook()");
		return "listBooks.xhtml";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		logger.info(">> getBookList()");
		bookList = bookEJB.findBooks();
		logger.info("<< getBookList()");
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
