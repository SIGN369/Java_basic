package com.tree.job.written.Y2017;

import org.junit.Test;

/**
 * @author zyg
 *
 */
public class Written {
	@Test
		public void StringTest() {
			String a = "Hello";
			String b= "Hello";
			String c = new String("Hello");
			System.out.println("a==b"+a==b);//false�ַ
			System.out.println("a==c"+a==c);//falseַ
			System.out.println("c.equal(Hello)"+c.equals("Hello"));//true
		}
	
	@Test
	public void DataRange() {
		
	}
	/*
	 * Java 全部都是值传递，不是引用传递
	 * 就是传递的参数只是一个副本，这个副本和原来的对象指向同一个位置，如果改变的副本的指向那么原对象不变
	 */
	public static void MathTest(String nn,int m) {
		float x = 1,y=2,z=3;
		//System.out.println(y+=z--/++x);
		System.out.println(nn);
		nn = "11111";
		m=9;
		System.out.println(nn);
	}
	public static void main(String[] args) {
		String a ="hhh";
		int m=1;
		MathTest(a,m);
		System.out.println(a+"-"+m);
	}
}
