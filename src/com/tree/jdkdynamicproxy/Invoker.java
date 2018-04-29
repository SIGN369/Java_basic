package com.tree.jdkdynamicproxy;

import org.junit.Test;


public class Invoker {
	/**
	 * ��̬����ʵ��
	 */
	@Test
		public void findHouse() {
			DynamicProxy dynamicProxy = new DynamicProxy();
			ProxyManage proxy = dynamicProxy.getProxy();//��ȡ�������Ŀ������е�������
			//ֱ�ӵ���Ŀ����󷽷�
			String rent = proxy.rent();
			System.out.println(rent);
		}
}
