package hu.gaborbalazs.practice.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import hu.gaborbalazs.practice.entity.Parent;

@Repository(forEntity = Parent.class)
public interface ParentRepository extends EntityRepository<Parent, Integer> {

}
