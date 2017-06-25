package hu.gaborbalazs.practice.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.ejb.ToyEJB;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.repository.ChildRepository;

@ManagedBean
@ViewScoped
public class ToyController {

	@Inject
	private Logger logger;

	@Inject
	private ToyEJB toyEJB;

	@Inject
	private ChildRepository childRepository;

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
}
