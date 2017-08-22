package hu.gaborbalazs.practice.ejb;

import javax.ejb.Stateless;

@Stateless
public class ServiceEjb {

	public int add(int a, int b) {
		return a + b;
	}

}
