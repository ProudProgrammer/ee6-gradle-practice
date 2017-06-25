package hu.gaborbalazs.practice.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import hu.gaborbalazs.practice.entity.Book;

@Repository(forEntity = Book.class)
public interface BookRepository extends EntityRepository<Book, Long> {

}
