package com.task08.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task08.dataformat.JsonOutputHelper;
import com.task08.dataformat.XmlOutputHelper;
import com.task08.user.Employee;

/**
 * 单元测试用例
 * @author Songbin83
 *
 */
public class UserService {

	@Test
	// XML输出测试
	public void testXML() {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee = (Employee) applicationContext.getBean("employee");

		System.out.println(new XmlOutputHelper().outputHelper(employee));
	}
	
	@Test
	// JSON输出测试
	public void testJson(){
		
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee = (Employee) applicationContext.getBean("employee");

		System.out.println(new JsonOutputHelper().outputHelper(employee));
	}
}
