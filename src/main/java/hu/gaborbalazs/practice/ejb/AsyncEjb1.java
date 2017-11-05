package hu.gaborbalazs.practice.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Stateless
@Asynchronous
@Loggable
public class AsyncEjb1 {

	@Inject
	private Logger logger;

	@Inject
	private AsyncEjb2 asyncEjb2;

	public void asyncMethod() throws InterruptedException {
		asyncEjb2.asyncMethod();
		logger.info("AsyncEjb2.asyncMethod() called, waiting a little...");
		Thread.sleep(1000);
	}
}
