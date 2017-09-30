package hu.gaborbalazs.practice.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.bean.CDITestBean;
import hu.gaborbalazs.practice.ejb.AsyncEjb1;

@ManagedBean
@RequestScoped
public class ButtonController {

	@Inject
	private Logger logger;

	@Inject
	private AsyncEjb1 asyncEjb1;
	
	@Inject
	private CDITestBean cdiTestBean;

	public void asyncEjbButtonListener() {
		logger.trace(">> asyncEjbButtonListener()");
		try {
			asyncEjb1.asyncMethod();
		} catch (InterruptedException e) {
			logger.error("AsyncMethod1() failed", e);
		}
		logger.trace("<< asyncEjbButtonListener()");
	}
	
	public void testCdiButtonListener() {
		logger.trace(">> testCdiButtonListener()");
		
		logger.trace("cdiTestBean: " + cdiTestBean.toString());
		
		logger.trace("<< testCdiButtonListener()");
	}
}
