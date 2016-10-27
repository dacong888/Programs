package com.dbusers.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Songbin83 Dao工厂类
 */
public class DaoFactory {

	private static Properties p = new Properties();
	// 缓存集合
	private static Map<String, Object> cach = new HashMap<String, Object>();

	static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			p.load(is);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static Object getInstance(String daoName) {

		Object object = cach.get(daoName);
		if (object == null) {

			String clazz = p.getProperty(daoName);
			if (clazz != null && clazz.equals("")) {
				try {
					object = Class.forName(clazz).newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return object;
	}

	@SuppressWarnings("unchecked")
	public synchronized static <T> T GetInstance(String daoName, Class daoClass) {

		T object = (T) cach.get(daoName);
		if (object == null) {
			String className = p.getProperty(daoName);
			if (className != null && !"".equals(className)) {
				try {
					// 加载指定名字的字节码到虚拟机内存中
					Class clazz = Class.forName(className);
					// 通过反射机制调用无参数的那个构造方法来创建出一个对象
					object = (T) daoClass.cast(clazz.newInstance());

					// 往缓存池中存放
					cach.put(daoName, object);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return object;
	}
}
