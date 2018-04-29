package com.tree.annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tree.annotation.CanAccess;
import com.tree.annotation.HostManager;
/**
 * 要熟悉Java的内存管理，主要是两大块
 * ①、堆--heap
 * ②、栈--stack
 * ③、方法区--位于堆内存中
 * 
 * class对象和实例对象的区别：
 * ①、熟悉类加载机制
 * ②、class对象在jvm中相当于一个模板有改类的所有信息，实例化时就是依靠这个模板创造
 * 		新的改类实例对象，在堆中分配内存
 * @author admin
 *
 */
public class AnnotatioTest {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//现在用户角色时开发，但是目标方法上的注解值时root，不是root时无法访问目标方法的
		 String role = "root";
		 //获取目标实例
		Class<?> clazz = Class.forName("com.tree.annotation.HostManager");
		//获取所有方法
		Method[] methods = clazz.getMethods();
		for(Method method:methods){
			//判断方法上是否出现了对应的注解
			boolean flag = method.isAnnotationPresent(CanAccess.class);
			if(flag){
				//值是否与预期保持一致
				CanAccess ass = method.getAnnotation(CanAccess.class);
				String role2 = ass.role();
				System.out.println(role2);
				boolean isCanAccess = role.equals(role2);
				//一致则调用方法
				if(isCanAccess){
					String str = (String) method.invoke(new HostManager(), "nothing");
					System.out.println(str);
				}
			}
		}
	}
}
