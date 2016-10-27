package com.task03.dto;

/**
 * 定义一个学生类，用于对表结构数据的添加与读取。
 * toString：用于打印数据。
 */
public class Student{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String addr;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "学生 ： [id ：" + id + "|" + "\t" + "姓名：" + name + "|" + "\t" + "年龄：" + age + "|" + "\t" + "性别：" + gender + "|" + "\t" + "地址：" + addr + "]";
	}
	
	
}
