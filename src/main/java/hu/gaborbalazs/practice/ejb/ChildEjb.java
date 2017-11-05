package hu.gaborbalazs.practice.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.ChildParent;
import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.repository.ChildRepository;

@Loggable
@Stateless
public class ChildEjb {

	@Inject
	private ChildRepository childRepository;

	@Inject
	private EntityManager em;

	public List<Child> getAllChild() {
		List<Child> children = childRepository.findAll();
		return children;
	}

	public Child find(int id) {
		Child child = childRepository.findBy(id);
		child.getParents().size();
		return child;
	}

	public ChildParent saveChildParent(ChildParent cp) {
		em.persist(cp);
		return cp;
	}
}
