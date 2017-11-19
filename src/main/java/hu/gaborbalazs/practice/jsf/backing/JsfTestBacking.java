package hu.gaborbalazs.practice.jsf.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Named
@RequestScoped
public class JsfTestBacking {

	private String text;

	public void init() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
