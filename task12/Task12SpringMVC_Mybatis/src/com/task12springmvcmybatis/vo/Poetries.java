package com.task12springmvcmybatis.vo;

public class Poetries {
	private int id;
	private int poet_id;
	private String title;
	private String content;
	private Poets poets;
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
	/**
	 * @return the poets
	 */
	public Poets getPoets() {
		return poets;
	}
	/**
	 * @param poets the poets to set
	 */
	public void setPoets(Poets poets) {
		this.poets = poets;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Poetries [id=" + id + ", poet_id=" + poet_id + ", title=" + title + ", content=" + content + ", poets="
				+ poets + "]";
	}
	
	
}
