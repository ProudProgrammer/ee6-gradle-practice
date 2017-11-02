package hu.gaborbalazs.practice.jsf.bean;

import java.util.UUID;

import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.impl.CDITestBean;
import hu.gaborbalazs.practice.ejb.AsyncEjb1;
import hu.gaborbalazs.practice.ejb.XATestEjb;
import hu.gaborbalazs.practice.entity.XATest;
import hu.gaborbalazs.practice.exception.BaseCheckedException;

@ManagedBean
@RequestScoped
public class IndexController {

	@Inject
	private Logger logger;

	@Inject
	private AsyncEjb1 asyncEjb1;
	
	@Inject
	private XATestEjb xaTestEjb;
	
	@Inject
	private CDITestBean cdiTestBean;
	
	@Inject
	private Event<String> textEvents;
	
	private String cdiEventText;
	
	public void asyncEjbButtonListener() {
		logger.trace(">> asyncEjbButtonListener()");
		try {
			asyncEjb1.asyncMethod();
		} catch (InterruptedException e) {
			logger.error("AsyncMethod1() failed", e);
		}
		logger.trace("<< asyncEjbButtonListener()");
	}
	
	public void xaTestListener() {
		logger.trace(">> XATestButtonListener()");
		XATest xaTest = new XATest();
		xaTest.setText(UUID.randomUUID().toString());
		xaTestEjb.createInGbPU(xaTest);
		XATest xaTest2 = new XATest();
		xaTest2.setText(UUID.randomUUID().toString());
		xaTestEjb.createInGbPU2(xaTest2);
		XATest xaTest3 = new XATest();
		xaTest3.setText(UUID.randomUUID().toString());
		XATest xaTest4 = new XATest();
		xaTest4.setText(UUID.randomUUID().toString());
		try {
			xaTestEjb.createInGbPUAndGbPU2(xaTest3, xaTest4);
		} catch (BaseCheckedException e) {
			logger.error(e.getMessage(), e);
		} finally {
			logger.trace("<< XATestButtonListener()");
		}
	}
	
	public void testCdiButtonListener() {
		logger.trace(">> testCdiButtonListener()");
		
		logger.trace("cdiTestBean: " + cdiTestBean.toString());
		
		logger.trace("<< testCdiButtonListener()");
	}
	
	public void testCdiEventButtonListener() {
		logger.trace(">> testCdiEventButtonListener()");
		
		logger.trace("cdiEventText: " + cdiEventText);
		textEvents.fire(cdiEventText);
		
		logger.trace("<< testCdiEventButtonListener()");
	}

	public String getCdiEventText() {
		return cdiEventText;
	}

	public void setCdiEventText(String cdiEventText) {
		this.cdiEventText = cdiEventText;
	}
}