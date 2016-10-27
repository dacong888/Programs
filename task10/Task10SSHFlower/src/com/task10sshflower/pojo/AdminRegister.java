package com.task10sshflower.pojo;

public class AdminRegister {
	private String userName;
	private String password;
	private String retryPassword;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
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
	 * @param password the password to set
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
	 * @param retryPassword the retryPassword to set
	 */
	public void setRetryPassword(String retryPassword) {
		this.retryPassword = retryPassword;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminRegister [userName=" + userName + ", password=" + password + ", retryPassword=" + retryPassword
				+ "]";
	}
	
}
