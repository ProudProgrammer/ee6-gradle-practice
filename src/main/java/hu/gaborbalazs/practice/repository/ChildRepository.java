package hu.gaborbalazs.practice.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import hu.gaborbalazs.practice.entity.Child;

@Repository(forEntity = Child.class)
public interface ChildRepository extends EntityRepository<Child, Integer> {

	@Query("select c from Child c join fetch c.parents p where c.id = ?1 and p.name = ?2")
	Child findByIdFetchParentByName(int childId, String parentName);

	@Query("select c from Child c join fetch c.parents p where c.id = ?1")
	Child findByIdFetchParent(int childId);

}
