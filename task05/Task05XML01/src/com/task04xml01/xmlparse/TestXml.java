package com.task04xml01.xmlparse;

public class TestXml {
	public static void main(String[] args) {
		//测试订单的读取与生成
		ParseXmlOrder px = new ParseXmlOrder();
		px.getGoods();
		px.genOrder();
		System.out.println("生成订单order.xml文件结束，请刷新项目查看。");
	}
}
