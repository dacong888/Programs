package com.task08spring02ssh.entity;

import java.util.Set;
/**
 * 数据库表Poets实体类
 * @author Songbin
 *
 */
public class Poets {
	private Integer id;
	private String name;
	private Set<Poetries> peotries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
