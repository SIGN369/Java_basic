package com.tree.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 类文件: 读取系统自定义配置
 * <p>
 * 类描述：
 */
@SuppressWarnings("rawtypes")
public class AppConfig {
	private static Properties config;

	static {
		//使用peoperties对象来加载已经读取为流的配置文件
		config = new Properties();

		try {
			Class appConfigClass = Class.forName("com.tree.util.AppConfig");//获取class对象，之后可以使用class对象的
			//class.getResourceAsStram()来读取文件配置
			InputStream is = appConfigClass.getResourceAsStream("/custom-config.properties");
			//加载配置
			config.load(is);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 这个Property对象实际和map一样，通过key获取参数
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		String value = config.getProperty(key);
		return value == null ? value : value.trim();
	}
	
	public static void main(String[] args) {
		String property = AppConfig.getProperty("WSUserName");
		System.out.println(property);
	}
}
