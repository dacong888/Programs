package com.task08spring02ssh.pojo;

import java.io.Serializable;
/**
 * POJO页面数据交互
 * @author Songbin
 *
 */
public class RetrievalContent implements Serializable {

	private static final long serialVersionUID = -2208002900920078344L;
	private String select;
	private String content;

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
