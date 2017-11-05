package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import hu.gaborbalazs.practice.entity.XATest;
import hu.gaborbalazs.practice.exception.BaseCheckedException;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Stateless
public class XATestEjb {

	@Inject
	private EntityManager entityManager;

	// @PersistenceContext(unitName = "gbPU2")
	private EntityManager entityManager2;

	public void createInGbPU(XATest xaTest) {
		entityManager.persist(xaTest);
	}

	public void createInGbPU2(XATest xaTest) {
		entityManager2.persist(xaTest);
	}

	public void createInGbPUAndGbPU2(XATest xaTest1, XATest xaTest2) throws BaseCheckedException {
		entityManager2.persist(xaTest2);
		entityManager.persist(xaTest1);
		throw new BaseCheckedException();
	}
}
