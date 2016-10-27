package com.task09sshvipsystem.pojo;

import java.math.BigDecimal;
/**
 * 定义商品POJO
 * @author Songbin
 *
 */
public class GoodsCollect {
	private String name;
	private BigDecimal price;
	private BigDecimal agio;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAgio() {
		return agio;
	}

	public void setAgio(BigDecimal agio) {
		this.agio = agio;
	}

}
