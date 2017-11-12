package hu.gaborbalazs.practice.ejb;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.impl.CDITestBean;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.Toy;
import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.repository.ChildRepository;

@Loggable
@Stateless
public class ToyEjb {

	@Inject
	private Logger logger;

	@Inject
	private ChildRepository childRepository;
	
	@Inject
	private ChildEjb childEjb;
	
	@Inject
	private EntityManager entityManager;
	
	@Inject
	private CDITestBean cdiTestBean;

	public Child findBy(int id) {
		Child child = childRepository.findBy(id);
		logger.info("Child: " + child);
		return child;
	}

	@Asynchronous
	public Future<Integer> asyncMethod() throws InterruptedException {
		int duration = ThreadLocalRandom.current().nextInt(100);
		boolean throwException = ThreadLocalRandom.current().nextBoolean();
		Thread.sleep(duration);
		logger.info("Thread name: " + Thread.currentThread().getName() + ", Thread id: "
				+ Thread.currentThread().getId() + ", Duration: " + duration + ", Exception: " + throwException);
		if (throwException) {
			throw new RuntimeException("duration: " + duration);
		}
		return new AsyncResult<Integer>(duration);
	}
	
	public void transactionTest() {
		Child child = childEjb.find(1);
		Toy toy = new Toy();
		toy.setName("Test Toy");
		toy.setOwner(child);
		entityManager.persist(toy);
		cdiTestBean.transactionTest();
		throw new IllegalStateException();
	}
}
