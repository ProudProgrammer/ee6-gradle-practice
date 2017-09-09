package hu.gaborbalazs.practice.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
@Asynchronous
public class AsyncEjb1 {

	@Inject
	private Logger logger;
	
	@Inject
	private AsyncEjb2 asyncEjb2;
	
	public void asyncMethod() throws InterruptedException {
		logger.trace(">> asyncMethod()");
		asyncEjb2.asyncMethod();
		logger.trace("AsyncEjb2.asyncMethod() called, waiting a little...");
		Thread.sleep(1000);
		logger.trace("<< asyncMethod()");
	}
	
	
}
