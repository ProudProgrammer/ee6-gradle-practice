package hu.gaborbalazs.practice.cdi.alternative;

import javax.enterprise.inject.Alternative;

import hu.gaborbalazs.practice.cdi.iface.Message;

@Alternative
public class DrunkMessage implements Message {

	@Override
	public String getMessage() {
		return "Burp!";
	}

}
