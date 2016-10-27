package com.task09sshvipsystem.pojo;
/**
 * 用户认证POJO
 * @author Songbin
 *
 */
public class UserAuth {
	private String username;
	private String password;
	private Integer quanxian;

	/**
	 * @return the quanxian
	 */
	public Integer getQuanxian() {
		return quanxian;
	}

	/**
	 * @param quanxian the quanxian to set
	 */
	public void setQuanxian(Integer quanxian) {
		this.quanxian = quanxian;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAuth [username=" + username + ", password=" + password + "]";
	}

}
