package hu.gaborbalazs.practice.model;

import javax.validation.constraints.NotNull;

public class Person {

	@NotNull
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int age;
}
