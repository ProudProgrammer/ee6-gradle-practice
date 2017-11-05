package hu.gaborbalazs.practice.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Stateless
@Asynchronous
@Loggable
public class AsyncEjb2 {

	@Inject
	private Logger logger;

	public void asyncMethod() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			logger.info("Waiting...");
			Thread.sleep(2000);
		}
	}
}
