package hu.gaborbalazs.practice.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.ejb.ParentEjb;
import hu.gaborbalazs.practice.entity.Parent;
import hu.gaborbalazs.practice.entity.ParentAux;
import hu.gaborbalazs.practice.repository.ParentRepository;

@ManagedBean
@ViewScoped
public class ParentController {

	@Inject
	private Logger logger;

	@Inject
	private ParentEjb parentEJB;

	@Inject
	private ParentRepository parentRepository;

	public void init() {
		logger.info(">> init()");
		logger.info("<< init()");
	}

	public List<Parent> mapTwoEntityForTheSameTeble() {
		logger.info(">> mapTwoEntityForTheSameTeble()");
		List<Parent> parents = parentRepository.findAll();
		ParentAux parentAux = new ParentAux();
		parentAux.setName("ParentAux");
		parentEJB.save(parentAux);
		logger.info("<< mapTwoEntityForTheSameTeble()");
		return parents;
	}

}
