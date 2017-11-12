package hu.gaborbalazs.practice.jsf.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Named
@RequestScoped
public class JsfTestBacking {

	private int amount;

	public void init() {
		amount = 100;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
