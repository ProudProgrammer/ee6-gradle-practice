package hu.gaborbalazs.practice.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.ejb.ChildEjb;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.ChildParent;

@ManagedBean
@ViewScoped
public class ChildController {

	@Inject
	private Logger logger;

	@Inject
	private ChildEjb childEJB;

	public void init() {
		logger.info(">> init()");
		logger.info("<< init()");
	}

	public List<Child> getAllChild() {
		logger.info(">> getAllChild()");
		List<Child> children = childEJB.getAllChild();
		logger.info("<< getAllChild(): " + children);
		return children;
	}

	public Child getChild(int id) {
		logger.info(">> printChild(): " + id);
		Child child = childEJB.find(id);
		logger.info("<< printChild(): " + id);
		return child;
	}

	public void insertRowToChildParent() {
		logger.info(">> insertRowToChildParent()");
		ChildParent cp = new ChildParent();
		cp.setChildId(3);
		cp.setParentId(1);
		childEJB.saveChildParent(cp);
		logger.info("<< insertRowToChildParent()");
	}
}
