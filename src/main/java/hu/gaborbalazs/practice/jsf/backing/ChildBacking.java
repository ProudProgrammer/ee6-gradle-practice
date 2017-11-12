package hu.gaborbalazs.practice.jsf.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.gaborbalazs.practice.ejb.ChildEjb;
import hu.gaborbalazs.practice.entity.Child;
import hu.gaborbalazs.practice.entity.ChildParent;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Named
@RequestScoped
public class ChildBacking {

	@Inject
	private ChildEjb childEJB;

	public void init() {
	}

	public List<Child> getAllChild() {
		List<Child> children = childEJB.getAllChild();
		return children;
	}

	public Child getChild(int id) {
		Child child = childEJB.find(id);
		return child;
	}

	public void insertRowToChildParent() {
		ChildParent cp = new ChildParent();
		cp.setChildId(3);
		cp.setParentId(1);
		childEJB.saveChildParent(cp);
	}
}
