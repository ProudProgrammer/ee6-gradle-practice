package hu.gaborbalazs.practice.cdi.observer;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

public class IndexObserver {

	@Inject
	private Logger logger;
	
	public void observe(@Observes String text) {
		logger.trace(">> observe()");
		logger.trace("Observed object: " + text);
		logger.trace("<< observe()");
	}
}
