package hu.gaborbalazs.practice.jsf.bean;

import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.impl.CDITestBean;
import hu.gaborbalazs.practice.ejb.AsyncEjb1;
import hu.gaborbalazs.practice.ejb.XATestEjb;
import hu.gaborbalazs.practice.entity.XATest;
import hu.gaborbalazs.practice.exception.BaseCheckedException;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Named
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
		try {
			asyncEjb1.asyncMethod();
		} catch (InterruptedException e) {
			logger.error("AsyncMethod1() failed", e);
		}
	}

	public void xaTestListener() {
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
		}
	}

	public void testCdiButtonListener() {
		logger.info("cdiTestBean: " + cdiTestBean.toString());
	}

	public void testCdiEventButtonListener() {
		logger.info("cdiEventText: " + cdiEventText);
		textEvents.fire(cdiEventText);
	}

	public String getCdiEventText() {
		return cdiEventText;
	}

	public void setCdiEventText(String cdiEventText) {
		this.cdiEventText = cdiEventText;
	}

}
