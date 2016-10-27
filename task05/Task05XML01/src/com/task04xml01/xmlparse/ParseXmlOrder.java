package com.task04xml01.xmlparse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//定义一个解析订单的XML类
public class ParseXmlOrder {
	//定义三个成员变量：total_price总价，total_count总量，goods商品目录。
	private int total_price;
	private int total_count;
	private List<Goods> goods = new LinkedList<>();

	//获取订单商品的总价与总数量，用于订单XML生成中的信息。
	private void getGoodsInfo() {
		for (Goods g : goods) {
			total_price += g.getPrice() * g.getNumber();
			total_count += g.getNumber();
		}
	}

	//用于读取shopping.xml文件，将其中的商品信息保存在goods成员变量中。
	public void getGoods() {
		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = df.newDocumentBuilder();
			Document doc = db.parse("shopping.xml");
			NodeList goodsElements = doc.getElementsByTagName("goods");
			int size = goodsElements.getLength();
			Goods gs;
			for (int i = 0; i < size; i++) {
				gs = new Goods();
				Node node = goodsElements.item(i);
				Element element = (Element) node;
				NodeList childList = element.getChildNodes();
				int clen = childList.getLength();
				for (int j = 0; j < clen; j++) {
					Node childNode = childList.item(j);
					String goodName = childNode.getNodeName();
					String var = childNode.getTextContent();

					if ("name".equals(goodName)) {
						gs.setName(var);
					} else if ("price".equals(goodName)) {
						gs.setPrice(Integer.parseInt(var));
					} else if ("number".equals(goodName)) {
						gs.setNumber(Integer.parseInt(var));
					}
				}
				goods.add(gs);
			}

			getGoodsInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//产生订单。
	public void genOrder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//根据要求，产生一个order.xml订单。
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("order");
			document.appendChild(root);
			Element total = document.createElement("total");
			
			//将总数与总量加入相应标签用于显示。
			total.appendChild(document.createTextNode(Integer.toString(total_price)));
			root.appendChild(total);
			Element sums = document.createElement("sums");
			sums.appendChild(document.createTextNode(Integer.toString(total_count)));
			root.appendChild(sums);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			document.setXmlVersion("1.0");

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			transformer.transform(source, new StreamResult(bos));

			//生成order.xml文件
			File file = new File("order.xml");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileOutputStream outputStream = new FileOutputStream(file);
			StreamResult xml = new StreamResult(outputStream);
			transformer.transform(source, xml);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
