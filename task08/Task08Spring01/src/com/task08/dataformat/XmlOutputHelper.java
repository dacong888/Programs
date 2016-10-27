package com.task08.dataformat;

import java.io.ByteArrayOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.task08.user.Employee;

/**
 * XML解析接口实现
 */
public class XmlOutputHelper implements IOutputHelper {

	// HTML/XML实体document
	private static Document document = null;

	static {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String outputHelper(Employee employees) {

		// 生成XML
		try {
			// create root
			Element root = document.createElement("employee");
			document.appendChild(root);

			// add id
			Element employeeId = document.createElement("id");
			employeeId.appendChild(document.createTextNode(Integer.toString(employees.getId())));
			root.appendChild(employeeId);

			// add name
			Element employeeName = document.createElement("name");
			employeeName.appendChild(document.createTextNode(employees.getName()));
			root.appendChild(employeeName);

			// add gender
			Element employeeGen = document.createElement("gender");
			employeeGen.appendChild(document.createTextNode(employees.getGender()));
			root.appendChild(employeeGen);

			// add age
			Element employeeAge = document.createElement("age");
			employeeAge.appendChild(document.createTextNode(Integer.toString(employees.getAge())));
			root.appendChild(employeeAge);

			// add phoneCall
			Element employeePhone = document.createElement("phonecall");
			employeePhone.appendChild(document.createTextNode(employees.getPhoneCall()));
			root.appendChild(employeePhone);

			// add address
			Element employeeAddr = document.createElement("address");
			employeeAddr.appendChild(document.createTextNode(employees.getAddress()));
			root.appendChild(employeeAddr);

			// 创建Transformer对象
			TransformerFactory tf = TransformerFactory.newInstance();

			// Transformer实例用于将source tree转变为result tree
			Transformer transformer = tf.newTransformer();

			// 生成一个转换source tree的DOM对象
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			document.setXmlVersion("1.0");

			// 创建一个byte array的输出流对象
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			// 将XML资源转换为result
			transformer.transform(source, new StreamResult(bos));

			// 输出结果
			return bos.toString();

			/*
			 * 写入文件代码 File file = new File("employee.xml"); if (!file.exists())
			 * { file.createNewFile(); } FileOutputStream outputStream = new
			 * FileOutputStream(file); StreamResult xml = new
			 * StreamResult(outputStream); transformer.transform(source, xml);
			 * System.out.println(1);
			 */
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return null;
	}

}
