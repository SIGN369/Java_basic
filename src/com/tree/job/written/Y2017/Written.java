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
	@Test
	public void MathTest() {
		float x = 1,y=2,z=3;
		System.out.println(y+=z--/++x);
	}
}
