package hu.gaborbalazs.practice.cdi.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {

	@PersistenceContext(unitName = "gbPU")
	private EntityManager em;

	@Produces
	public EntityManager createEntityManager() {
		return em;
	}

	@Produces
	private Logger createLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
