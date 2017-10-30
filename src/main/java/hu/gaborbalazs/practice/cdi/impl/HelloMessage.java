package hu.gaborbalazs.practice.cdi.impl;

import hu.gaborbalazs.practice.cdi.iface.Message;

public class HelloMessage implements Message {

	@Override
	public String getMessage() {
		return "Hello";
	}

}
