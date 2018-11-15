package com.tree.jdkdynamicproxy.testobj;

import com.tree.jdkdynamicproxy.ProxyManage;

public class Landlord  implements ProxyManage {
	
	private String key = "I am a key";
	@Override
	public String rent() {
		return key;
	}
}
