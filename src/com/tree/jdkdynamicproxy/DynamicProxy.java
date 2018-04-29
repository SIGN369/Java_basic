package com.tree.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.tree.jdkdynamicproxy.testobj.Landlord;


/**
 * class��������ͨJava���������
 * @author zyg
 *tip��JunitTest��Ԫ����-->���ܴ�������û�з���ֵ
 *��̬-һ��������ͬһ���µĲ�ͬ������в�ͬ��Ч��
 */
public class DynamicProxy {
		
	public ProxyManage getProxy() {
		
		Landlord landlord = new Landlord();
		//1.���ɴ������
		/**
		 * loader-Ŀ�������������,����ȡĿ������ֽ������(class)
		 * interfaces-�����Ƕ���ӿڣ�������-new Class[] {Tenant.class} //����landlord.getClass().getInterfaces()
		 * InvocationHandler-ʹ�������ڲ�����ʵ�֣�
		 */
		ProxyManage proxyInstance = (ProxyManage) Proxy.newProxyInstance(landlord.getClass().getClassLoader(),landlord.getClass().getInterfaces() , new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("��Ǯ");
				//ȥ����Ŀ�귽��
				Object invoke = method.invoke(landlord, args);
				System.out.println("������Ǯ");
				return invoke;
			}
		});
			return proxyInstance;
	}
}
