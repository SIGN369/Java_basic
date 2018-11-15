package com.tree.jdkdynamicproxy.testobj;



import java.util.Scanner;

import org.junit.Test;

import com.tree.jdkdynamicproxy.StaticProxy;

public class Tenant{
	@Test
	public void  findHouse() {
		StaticProxy proxy  = new StaticProxy();
		String key = proxy.rent();
		Scanner sc = new Scanner(System.in);
		System.out.println(key);
	}
}
