package com.tree.test;


public class StringSpliTest {

	public static void main(String[] args) {
		String str= "";//字符串常量池中引用
		String str2 = "";
		String[] split = str.split(",");
		System.out.println(split.length);
		System.out.println(str.isEmpty());
		System.out.println("测试："+str==str2);
		//hashCode 代表对象存储的物理位置的映射在hash表中的hash值
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
	}
}
