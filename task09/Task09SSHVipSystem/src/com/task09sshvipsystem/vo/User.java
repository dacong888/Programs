package com.task09sshvipsystem.vo;
/**
 * 用户实体类
 * @author Songbin
 *
 */
public class User {
	private String username;
	private String password;
	private Integer quanxian;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(Integer quanxian) {
		this.quanxian = quanxian;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", quanxian=" + quanxian + "]";
	}

}
