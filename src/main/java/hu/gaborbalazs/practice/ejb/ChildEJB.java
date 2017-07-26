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
	
	public ChildParent saveChildParent(ChildParent cp) {
		logger.info(">> saveChildParent(): " + cp);
		em.persist(cp);
		cp = em.merge(cp);
		em.flush();
		logger.info("<< saveChildParent()" + cp);
		return cp;
	}
}
