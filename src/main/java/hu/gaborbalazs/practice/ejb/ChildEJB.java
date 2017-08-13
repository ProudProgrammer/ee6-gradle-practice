package hu.gaborbalazs.practice.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.ChildParent;
import hu.gaborbalazs.practice.repository.ChildRepository;

@Stateless
public class ChildEJB {

	@Inject
	private Logger logger;
	
	@Inject
	private ChildRepository childRepository;
	
	@Inject
	private EntityManager em;
	
	public List<Child> getAllChild() {
		logger.info(">> getAllChild()");
		List<Child> children = childRepository.findAll();
		logger.info("<< getAllChild(): " + children);
		return children;
	}
	
	public Child find(int id) {
		logger.info(">> find(): " + id);
		Child child = childRepository.findBy(id);
		child.getParents().size();
		logger.info("<< find(): " + id);
		return child;
	}
	
	public ChildParent saveChildParent(ChildParent cp) {
		logger.info(">> saveChildParent(): " + cp);
		em.persist(cp);
		logger.info("<< saveChildParent()" + cp);
		return cp;
	}
}
