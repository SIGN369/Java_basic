package com.tree.jdkdynamicproxy;

import org.junit.Test;


public class Invoker {
	@Test
		public void findHouse() {
			DynamicProxy dynamicProxy = new DynamicProxy();
			ProxyManage proxy = dynamicProxy.getProxy();
			String rent = proxy.rent();
			System.out.println(rent);
		}
}
