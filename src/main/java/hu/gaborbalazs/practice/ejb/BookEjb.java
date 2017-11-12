package hu.gaborbalazs.practice.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.gaborbalazs.practice.entity.Book;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Stateless
public class BookEjb {

	@PersistenceContext(unitName = "gbPU")
	private EntityManager em;

	public Book findById(Long id) {
		Book book = em.find(Book.class, id);
		return book;
	}

	public Book save(Book book) {
		book = em.merge(book);
		em.flush();
		return book;
	}

	public List<Book> findBooks() {
		TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
		return query.getResultList();
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void transactionTest() {
		Book book = new Book();
		book.setTitle("Test Book");
		book.setDescription("This is a test book");
		book.setIllustrations(false);
		book.setIsbn("isbn-001-0002");
		book.setPrice(5100f);
		book.setNbOfPage(350);
		em.persist(book);
	}
}
