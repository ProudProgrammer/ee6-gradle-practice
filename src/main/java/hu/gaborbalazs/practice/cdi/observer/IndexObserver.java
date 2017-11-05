package hu.gaborbalazs.practice.cdi.observer;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
public class IndexObserver {

	@Inject
	private Logger logger;
	
	public void observe(@Observes String text) {
		logger.info("Observed object: " + text);
	}
}
