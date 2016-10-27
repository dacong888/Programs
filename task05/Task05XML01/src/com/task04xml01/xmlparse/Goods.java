package com.task04xml01.xmlparse;

//将shopping.xml订单抽象成一个Goods类
public class Goods {
	//定义三个成员变量：name商品名称，price商品价格，number商品数量。
	private String name;
	private int price;
	private int number;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", count=" + number + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Goods otherGoods = (Goods) obj;
		if (name == null) {
			if (otherGoods.name != null) {
				return false;
			}
		} else if (!name.equals(otherGoods.name)) {
			return false;
		}

		if (price != otherGoods.price) {
			return false;
		}

		if (number != otherGoods.number) {
			return false;
		}
		return true;
	}
}
