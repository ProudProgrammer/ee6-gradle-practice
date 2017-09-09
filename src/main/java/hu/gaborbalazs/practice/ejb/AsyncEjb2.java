package hu.gaborbalazs.practice.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
@Asynchronous
public class AsyncEjb2 {

	@Inject
	private Logger logger;
	
	public void asyncMethod() throws InterruptedException {
		logger.trace(">> asyncMethod");
		for (int i = 0; i < 3; i++) {
			logger.trace("Waiting...");
			Thread.sleep(2000);
		}
		logger.trace("<< asyncMethod");
	}
}
