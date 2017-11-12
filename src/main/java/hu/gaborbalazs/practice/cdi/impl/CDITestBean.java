package hu.gaborbalazs.practice.cdi.impl;

import java.text.MessageFormat;

import javax.inject.Inject;

import hu.gaborbalazs.practice.ejb.BookEjb;
import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
public class CDITestBean {

	@Inject
	private BookEjb bookEjb;
	
	private String name = "CDITestBean";
	
	private int number = 10;

	public void transactionTest() {
		bookEjb.transactionTest();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return MessageFormat.format("[CDITestBean: name={0}, number={1}]", name, number);
	}

}
