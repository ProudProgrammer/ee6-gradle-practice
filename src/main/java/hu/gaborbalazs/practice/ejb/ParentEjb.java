package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.entity.ParentAux;

@Stateless
public class ParentEjb {

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;

	public ParentAux save(ParentAux parent) {
		logger.info(">> save(" + parent + ")");
		parent = em.merge(parent);
		em.flush();
		logger.info("<< save(" + parent + ")");
		return parent;
	}
}
