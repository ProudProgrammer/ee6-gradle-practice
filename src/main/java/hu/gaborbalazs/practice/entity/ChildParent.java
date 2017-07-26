package hu.gaborbalazs.practice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@SuppressWarnings("serial")
@Entity
@Table(name = "child_parent")
public class ChildParent implements Serializable {

	@Id
	@Column(name = "child_id")
	private int childId;

	@Id
	@Column(name = "parent_id")
	private int parentId;

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("childId", getChildId()).add("parentId", getParentId()).toString();
	}
}
