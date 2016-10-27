package com.task10sshflower.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Orders {
	private int ordersId;
	private String userName;
	private int num;
	private BigDecimal sum;
	private Date createTime;
	private Set<OrderDetails> orderDetails;

	/**
	 * @return the ordersId
	 */
	public int getOrdersId() {
		return ordersId;
	}

	/**
	 * @param ordersId
	 *            the ordersId to set
	 */
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

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
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the sum
	 */
	public BigDecimal getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            the sum to set
	 */
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", userName=" + userName + ", num=" + num + ", sum=" + sum
				+ ", createTime=" + createTime + ", orderDetails=" + orderDetails + "]";
	}

}
