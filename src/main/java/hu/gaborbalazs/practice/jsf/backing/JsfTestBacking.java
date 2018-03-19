package hu.gaborbalazs.practice.jsf.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.model.Person;

@Loggable
@Named
@RequestScoped
public class JsfTestBacking {

    @Inject
    private Logger logger;
    
	private String text;

	public void init() {
	    logger.trace("begin");
	    Person person = new Person();
	    person.setAge(20);
	    person.setName("Bob");
	    logger.trace(person.toString());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
