package hu.gaborbalazs.practice.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.ejb.ToyEJB;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.Toy;
import hu.gaborbalazs.practice.repository.ChildRepository;
import hu.gaborbalazs.practice.repository.ToyRepository;

@ManagedBean
@ViewScoped
public class ToyController {

	@Inject
	private Logger logger;

	@Inject
	private ToyEJB toyEJB;

	@Inject
	private ChildRepository childRepository;

	@Inject
	private ToyRepository toyRepository;

	@Inject
	private EntityManager em;

	public void init() {
		logger.info(">> init()");

		Child child1 = null;
		try {
			child1 = childRepository.findByIdFetchParentByName(1, "Susan");
		} catch (NoResultException e) {
			logger.info("No child found");
		}
		logger.info("Child1: " + child1);

		Child child2 = null;
		try {
			child2 = childRepository.findByIdFetchParent(2);
		} catch (NoResultException e) {
			logger.info("No child found");
		}
		logger.info("Child2: " + child2);

		logger.info("<< init()");
	}

	public String criteriaTest() {
		logger.info(">> criteriaTest()");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Toy> c = cb.createQuery(Toy.class);
		Root<Toy> toy = c.from(Toy.class);
		c.select(toy).where(cb.equal(toy.get("id"), "1"));
		List<Toy> toys = em.createQuery(c).getResultList();
		logger.info("<< criteriaTest()");
		if (toys.isEmpty()) {
			return "No result found";
		}
		return toys.get(0).toString();
	}

	public List<Toy> getToyNames() {
		logger.info(">> getToyNames()");
		logger.info("<< getToyNames()");
		return toyRepository.findAllNameColumn();
	}
}
