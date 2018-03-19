package hu.gaborbalazs.practice.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

	@NotNull
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int age;
	
	public String personAsString() {
	    return this.getName() + this.getId();
	}
}
