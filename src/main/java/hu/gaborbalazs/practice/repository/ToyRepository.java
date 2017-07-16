package hu.gaborbalazs.practice.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import hu.gaborbalazs.practice.entity.Toy;

@Repository(forEntity = Toy.class)
public interface ToyRepository extends EntityRepository<Toy, Integer> {

	@Query("select t.name from Toy t")
	List<Toy> findAllNameColumn();
}
