package com.task09sshvipsystem.pojo;
/**
 * 用户登录POJO
 * @author Songbin
 *
 */
public class LoginRegister {
	private String userName;
	private String password;
	private String retryPassword;
	private int privilage;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the retryPassword
	 */
	public String getRetryPassword() {
		return retryPassword;
	}

	/**
	 * @param retryPassword
	 *            the retryPassword to set
	 */
	public void setRetryPassword(String retryPassword) {
		this.retryPassword = retryPassword;
	}

	/**
	 * @return the privilage
	 */
	public int getPrivilage() {
		return privilage;
	}

	/**
	 * @param privilage
	 *            the privilage to set
	 */
	public void setPrivilage(int privilage) {
		this.privilage = privilage;
	}

}
