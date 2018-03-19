package hu.gaborbalazs.practice.jsf.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.validation.group.JsfTestValidationGroup;
import hu.gaborbalazs.practice.model.Person;

@Loggable
@Named
@RequestScoped
public class JsfTestBacking {

    @Inject
    private Logger logger;
    
	private String text;
	
	@Size(min = 2, max = 3, message = "Input length must be between 2 an 3", groups = JsfTestValidationGroup.class)
	private String validatedText;

	public void init() {
	    logger.trace("begin");
	    Person person = new Person();
	    person.setAge(20);
	    person.setName("Bob");
	    logger.trace(person.toString());
	}

	public void submitListener() {
		logger.trace("text: {}, validatedText: {}", text, validatedText);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValidatedText() {
		return validatedText;
	}

	public void setValidatedText(String validatedText) {
		this.validatedText = validatedText;
	}

}
