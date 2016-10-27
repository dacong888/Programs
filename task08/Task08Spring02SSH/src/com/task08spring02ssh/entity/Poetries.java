package com.task08spring02ssh.entity;
/**
 * 数据库表Poetries实体类
 * @author Songbin
 *
 */
public class Poetries {
	private int id;
	private int poet_id;
	private String content;
	private String title;
	private Poets poets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoet_id() {
		return poet_id;
	}

	public void setPoet_id(int poet_id) {
		this.poet_id = poet_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Poets getPoets() {
		return poets;
	}

	public void setPoets(Poets poets) {
		this.poets = poets;
	}

}
