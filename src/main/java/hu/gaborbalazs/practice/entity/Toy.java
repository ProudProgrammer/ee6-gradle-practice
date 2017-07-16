package hu.gaborbalazs.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.common.base.MoreObjects;

@Entity
public class Toy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToOne
	private Child owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Child getOwner() {
		return owner;
	}

	public void setOwner(Child owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", getId()).add("name", getName()).toString();
	}
}
