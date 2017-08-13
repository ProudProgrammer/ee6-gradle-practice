package hu.gaborbalazs.practice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.google.common.base.MoreObjects;

@Entity
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "child_parent", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
	private List<Parent> parents;

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

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", getId()).add("name", getName()).add("parents", getParents())
				.toString();
	}
}
