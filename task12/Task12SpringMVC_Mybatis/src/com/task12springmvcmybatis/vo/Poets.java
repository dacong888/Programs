package com.task12springmvcmybatis.vo;

import java.util.List;

public class Poets {
	private int id;
	private String name;
	private List<Poetries> poetries;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the poetries
	 */
	public List<Poetries> getPoetries() {
		return poetries;
	}
	/**
	 * @param poetries the poetries to set
	 */
	public void setPoetries(List<Poetries> poetries) {
		this.poetries = poetries;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Poets [id=" + id + ", name=" + name + ", poetries=" + poetries + "]";
	}
	
}
