package com.task04DB.dto;

public class PoetInfo {
	private int id;
	private int poet_id;
	private String name;
	private String title;
	private String content;
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
	 * @return the poet_id
	 */
	public int getPoet_id() {
		return poet_id;
	}
	/**
	 * @param poet_id the poet_id to set
	 */
	public void setPoet_id(int poet_id) {
		this.poet_id = poet_id;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoetInfo [id=" + id + ", poet_id=" + poet_id + ", name=" + name + ", title=" + title + ", content="
				+ content + "]";
	}
	
	
}
