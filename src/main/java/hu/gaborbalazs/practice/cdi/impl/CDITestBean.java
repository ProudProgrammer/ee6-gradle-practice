package hu.gaborbalazs.practice.cdi.impl;

import java.text.MessageFormat;

public class CDITestBean {

	private String name = "CDITestBean";
	private int number = 10;
	
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
