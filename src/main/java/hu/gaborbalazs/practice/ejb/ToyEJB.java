package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.repository.ChildRepository;

@Stateless
public class ToyEJB {

	@Inject
	private Logger logger;
	
	@Inject
	private ChildRepository childRepository;
	
	public Child findBy(int id) {
		logger.info(">> findBy");
		Child child = childRepository.findBy(id);
		logger.info("Child: " + child);
		logger.info("<< findBy");
		return child;
	}
}
