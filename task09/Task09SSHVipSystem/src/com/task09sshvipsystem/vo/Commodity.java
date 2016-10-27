package com.task09sshvipsystem.vo;

import java.math.BigDecimal;
/**
 * 商品实体类
 * @author Songbin
 *
 */
public class Commodity {
	private Integer commodityId;
	private String commodityName;
	private BigDecimal price;
	private BigDecimal agio;

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
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
