package com.tree.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.tree.po.TestPo;

/**
 * Java 反射练习
 * ①、使用反射来封装映射数据  Map<String,String>
 * ②、用来获取类信息，实例
 * @author zyg
 *
 */
public class ReflectDemo {
		
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		//1、获取字节码对象
		Class<?> clazz = TestPo.class;
		Object newInstance = clazz.newInstance();
		//2、获取所有属性
		Field[] declaredFields = clazz.getDeclaredFields();
		Map<String,Object> params = new HashMap();
		for (Field field : declaredFields) {
			//添加字段访问权限
			field.setAccessible(true);
			System.out.println("属性【【field】："+field.getName()+"属性值;"+field.get(newInstance));
			params.put(field.getName(), field.get(newInstance));
			//将map中值对应复制给实体类
			
		}
		//3、获取所有方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println("方法【method】："+method.getName());
		}
		//4、获取所有注解
		Annotation[] annotations = clazz.getAnnotations();
		
		//5、使用反射来给类属性复制
		
		for (Object entry : params.entrySet()) {
			String string = entry.toString();
			System.out.println("prams:" +string+""+entry.getClass().getName());
			
		}
		
		
		
	}
}
