package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;

import hu.gaborbalazs.practice.interceptor.Loggable;

@Loggable
@Stateless
public class ServiceEjb {

	public int add(int a, int b) {
		return a + b;
	}

}
