package hu.gaborbalazs.practice.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.ejb.BookEJB;
import hu.gaborbalazs.practice.entity.Book;

@ManagedBean(name = "bookController")
@RequestScoped
public class BookController {
	
	@Inject
	Logger logger;
	
	@EJB
	private BookEJB bookEJB;

	private Book book = new Book();
	private List<Book> bookList = new ArrayList<>();

	public BookController() {}

	public String doCreateBook() {
		logger.info(">> doCreateBook()");
		book = bookEJB.createBook(book);
		bookList = bookEJB.findBooks();
		logger.info("<< doCreateBook()");
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
}
