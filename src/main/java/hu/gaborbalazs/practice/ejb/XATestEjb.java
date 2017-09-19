package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.entity.XATest;
import hu.gaborbalazs.practice.exception.BaseCheckedException;

@Stateless
public class XATestEjb {
	
	@Inject
	private Logger logger;

	@Inject
	private EntityManager entityManager;
	
	@PersistenceContext(unitName = "gbPU2")
	private EntityManager entityManager2;
	
	public void createInGbPU(XATest xaTest) {
		logger.trace(">> createInGbPU({})", xaTest);
		entityManager.persist(xaTest);
		logger.trace("<< createInGbPU({})", xaTest);
	}
	
	public void createInGbPU2(XATest xaTest) {
		logger.trace(">> createInGbPU2({})", xaTest);
		entityManager2.persist(xaTest);
		logger.trace("<< createInGbPU2({})", xaTest);
	}
	
	public void createInGbPUAndGbPU2(XATest xaTest1, XATest xaTest2) throws BaseCheckedException {
		logger.trace(">> createInGbPUAndGbPU2({}, {})", xaTest1, xaTest2);
		try { 
			entityManager2.persist(xaTest2);
			entityManager.persist(xaTest1);
			throw new BaseCheckedException();
		} finally {
			logger.trace("<< createInGbPUAndGbPU2({}, {})", xaTest1, xaTest2);
		}
	}
}
