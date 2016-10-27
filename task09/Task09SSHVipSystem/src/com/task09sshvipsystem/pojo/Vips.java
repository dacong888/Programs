package com.task09sshvipsystem.pojo;

import java.util.Date;
/**
 * VIP POJO
 * @author Songbin
 *
 */
public class Vips {
	private int id;
	private Date joinTime;
	private String name;
	private int age;
	private String profession;

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Vips [joinTime=" + joinTime + ", name=" + name + ", age=" + age + ", profession=" + profession + "]";
	}

}
