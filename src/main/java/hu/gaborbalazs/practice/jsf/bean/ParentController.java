package hu.gaborbalazs.practice.jsf.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.gaborbalazs.practice.ejb.ParentEjb;
import hu.gaborbalazs.practice.entity.Parent;
import hu.gaborbalazs.practice.entity.ParentAux;
import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.repository.ParentRepository;

@Loggable
@Named
@RequestScoped
public class ParentController {

	@Inject
	private ParentEjb parentEJB;

	@Inject
	private ParentRepository parentRepository;

	public void init() {
	}

	public List<Parent> mapTwoEntityForTheSameTeble() {
		List<Parent> parents = parentRepository.findAll();
		ParentAux parentAux = new ParentAux();
		parentAux.setName("ParentAux");
		parentEJB.save(parentAux);
		return parents;
	}

}
