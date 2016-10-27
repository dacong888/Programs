package com.task09sshvipsystem.vo;

import java.math.BigDecimal;
/**
 * 购物信息实体类
 * @author Songbin
 *
 */
public class Consume {
	private Integer consumeId;
	private Integer vipId;
	private String name;
	private Integer commodityId;
	private String commodityName;
	private BigDecimal price;
	private BigDecimal pracitcePrice;

	public Integer getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public BigDecimal getPracitcePrice() {
		return pracitcePrice;
	}

	public void setPracitcePrice(BigDecimal pracitcePrice) {
		this.pracitcePrice = pracitcePrice;
	}

}
