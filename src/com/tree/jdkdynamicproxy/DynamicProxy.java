package com.tree.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.tree.jdkdynamicproxy.testobj.Landlord;


public class DynamicProxy {
		
	public ProxyManage getProxy() {
		
		Landlord landlord = new Landlord();
		ProxyManage proxyInstance = (ProxyManage) Proxy.newProxyInstance(landlord.getClass().getClassLoader(),landlord.getClass().getInterfaces() , new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object invoke = method.invoke(landlord, args);
				return invoke;
			}
		});
			return proxyInstance;
	}
}
