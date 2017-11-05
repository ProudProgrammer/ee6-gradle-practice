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
}
