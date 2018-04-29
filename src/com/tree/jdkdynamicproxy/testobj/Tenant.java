package com.tree.jdkdynamicproxy.testobj;



import java.util.Scanner;

import org.junit.Test;

import com.tree.jdkdynamicproxy.StaticProxy;

public class Tenant{
	@Test
		/**
		 * ���ͣ���Ҫ���н��ⷿ
		 * 
		 * ��̬����ͳһʵ��һ������-ʹ�ýӿ����淶����֤���������Ŀ�����ķ���ǩ��һ��
		 * ��������ȱ��ܶ࣬����ÿ��Ŀ������޸ģ��������ӷ���ʱ������ҲҪ�ֶ��޸Ĳ����ϳ������
		 * ��ʹ�ö�̬��������̬����
		 * �����ڷ���������������Ŀ��������һ��rentWC(),��ô����Ҫȥ�ֶ�ȥд���RentWC(),�鷳
		 * 
		 * ��û��һ�ַ����ܹ�Ϊ�������ɶ�̬����������ǲ�д����ֻд��չ���֣�������ֱ�ӵ��ö�Ӧ��������
		 * ��ʡ�˴������������дÿһ�������Ĳ���
		 * 
		 * ʹ�ô�����Ƕ�ԭ���������м�ǿ�����Ǻ��ķ�������
		 */
	public void  findHouse() {
		StaticProxy proxy  = new StaticProxy();
		String key = proxy.rent();
		Scanner sc = new Scanner(System.in);
		System.out.println(key);
	}
}
