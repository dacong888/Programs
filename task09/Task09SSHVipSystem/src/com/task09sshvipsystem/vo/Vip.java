package com.task09sshvipsystem.vo;
/**
 * VIP实体类
 */
import java.util.Date;

public class Vip {
	private int vipId;
	private Date joinTime;
	private String name;
	private int age;
	private String profession;

	/**
	 * @return the vipId
	 */
	public int getVipId() {
		return vipId;
	}

	/**
	 * @param vipId
	 *            the vipId to set
	 */
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	/**
	 * @return the joinTime
	 */
	public Date getJoinTime() {
		return joinTime;
	}

	/**
	 * @param joinTime
	 *            the joinTime to set
	 */
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

}
