package hu.gaborbalazs.practice.jsf.backing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.ejb.ToyEjb;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.Toy;
import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.repository.ChildRepository;
import hu.gaborbalazs.practice.repository.ToyRepository;

@Loggable
@Named
@RequestScoped
public class ToyBacking {

	@Inject
	private Logger logger;

	@Inject
	private ToyEjb toyEJB;

	@Inject
	private ChildRepository childRepository;

	@Inject
	private ToyRepository toyRepository;

	@Inject
	private EntityManager em;

	public void init() {
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

		Child child3 = null;
		try {
			child3 = childRepository.findByIdFetchParent(3);
		} catch (NoResultException e) {
			logger.info("No child found");
		}
		logger.info("Child3: " + child3);
	}

	public String criteriaTest() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Toy> c = cb.createQuery(Toy.class);
		Root<Toy> toy = c.from(Toy.class);
		c.select(toy).where(cb.equal(toy.get("id"), "1"));
		List<Toy> toys = em.createQuery(c).getResultList();
		if (toys.isEmpty()) {
			return "No result found";
		}
		return toys.get(0).toString();
	}

	public List<Toy> getToyNames() {
		List<Toy> toys = toyRepository.findAllNameColumn();
		return toys;
	}

	public void asyncTest() throws InterruptedException {
		List<Future<Integer>> requestList = new ArrayList<>();
		List<Integer> resultList = new ArrayList<>();
		int requests = 3;
		for (int i = 0; i < requests; i++) {
			requestList.add(toyEJB.asyncMethod());
		}
		for (Future<Integer> f : requestList) {
			try {
				resultList.add(f.get());
			} catch (ExecutionException e) {
				logger.error("Error: " + e.getMessage());
			}
		}
		logger.info("ResultList size: " + resultList.size() + ", ResultList: " + resultList);
	}
}
