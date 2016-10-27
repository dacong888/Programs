package com.task07hibernate01.entity;

import java.util.Set;

//主键
public class Poets {
	private int id;
	private String name;
	private Set<Poetries> peotries;

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

	public Set<Poetries> getPeotries() {
		return peotries;
	}

	public void setPeotries(Set<Poetries> peotries) {
		this.peotries = peotries;
	}

	@Override
	public String toString() {
		return "Poets [id=" + id + ", name=" + name + ", peotries=" + peotries + "]";
	}
	
	

//	@Override
//	public String toString() {
//		return "Poets [id=" + id + ", name=" + name + ", peotries=" + peotries + "]";
//	}

	// private int id;
	// private String name;
	// private Poetries poetries;
	//
	// public Poetries getPoetries() {
	// return poetries;
	// }
	//
	// public void setPoetries(Poetries poetries) {
	// this.poetries = poetries;
	// }
	//
	// public Poets(int id, String name) {
	// this.id = id;
	// this.name = name;
	// }
	//
	// public int getId() {
	// return id;
	// }
	//
	// public void setId(int id) {
	// this.id = id;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// @Override
	// public String toString() {
	// return "Poets [id=" + id + ", name=" + name + ", poetries=" + poetries +
	// "]";
	// }

}
