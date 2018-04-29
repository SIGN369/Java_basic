package com.tree.jdkdynamicproxy;

import com.tree.jdkdynamicproxy.testobj.Landlord;

public class StaticProxy  implements ProxyManage{
	/**
	 * �н��Ǵ������-
	 * �н��ⷿ�����ⷿǰ�󶼿�����һЩ��,��Ӧʵ���е�һЩ��������
	 * �ⷿǰ���ն���
	 * �ⷿ����ȡӶ��
	 */
	@Override
	public String rent() {
		Landlord landlord = new Landlord();
		System.out.println("�ն���...");//����ĺô�������������ȡ��ͬ���룬ֻд���Ĳ���
		String key = landlord.rent();
		System.out.println("��ȡӶ��...");//����ĺô�������������ȡ��ͬ���룬ֻд���Ĳ���
		return key;
	}
}
