package com.task10sshflower.pojo;

public class UserRegister {
	private String userName;
	private String realName;
	private String password;
	private String pwdQuestion;
	private String pwdQuestionAnswer;
	private String address;
	private String phoneNO;
	private String email;

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
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName
	 *            the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * @return the pwdQuestion
	 */
	public String getPwdQuestion() {
		return pwdQuestion;
	}

	/**
	 * @param pwdQuestion
	 *            the pwdQuestion to set
	 */
	public void setPwdQuestion(String pwdQuestion) {
		this.pwdQuestion = pwdQuestion;
	}

	/**
	 * @return the pwdQuestionAnswer
	 */
	public String getPwdQuestionAnswer() {
		return pwdQuestionAnswer;
	}

	/**
	 * @param pwdQuestionAnswer
	 *            the pwdQuestionAnswer to set
	 */
	public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
		this.pwdQuestionAnswer = pwdQuestionAnswer;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNO
	 */
	public String getPhoneNO() {
		return phoneNO;
	}

	/**
	 * @param phoneNO
	 *            the phoneNO to set
	 */
	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRegister [userName=" + userName + ", realName=" + realName + ", password=" + password
				+ ", pwdQuestion=" + pwdQuestion + ", pwdQuestionAnswer=" + pwdQuestionAnswer + ", address=" + address
				+ ", phoneNO=" + phoneNO + ", email=" + email + "]";
	}

}
