package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import hu.gaborbalazs.practice.entity.ParentAux;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Stateless
public class ParentEjb {

	@Inject
	private EntityManager em;

	public ParentAux save(ParentAux parent) {
		parent = em.merge(parent);
		em.flush();
		return parent;
	}
}
