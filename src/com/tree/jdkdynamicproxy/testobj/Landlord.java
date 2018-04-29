package com.tree.jdkdynamicproxy.testobj;

import com.tree.jdkdynamicproxy.ProxyManage;

public class Landlord  implements ProxyManage {
		/**
		 * ������Ŀ�����
		 * ��̬����
		 * ����-�ṩ�ⷿ����rent
		 */
	
	private String key = "Կ��";
	@Override
	public String rent() {
		return key;
	}
}
