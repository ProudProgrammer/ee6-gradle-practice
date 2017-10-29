package hu.gaborbalazs.practice.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import hu.gaborbalazs.practice.cdi.iface.Message;

@Decorator
public class HelloMessageDecorator implements Message {

	@Inject @Delegate
	private Message message;
	
	@Override
	public String getMessage() {
		return message.getMessage() + " World";
	}

}
