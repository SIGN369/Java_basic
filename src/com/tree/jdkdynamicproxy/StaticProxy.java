package com.tree.jdkdynamicproxy;

import com.tree.jdkdynamicproxy.testobj.Landlord;

public class StaticProxy  implements ProxyManage{
	@Override
	public String rent() {
		Landlord landlord = new Landlord();
		String key = landlord.rent();
		return key;
	}
}
