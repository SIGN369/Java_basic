package com.tree.initorder;

public class Children extends Parent{ 
	static {
		System.out.println("Children static block--");
	}
	{
		System.out.println("Children block");
	}
	public Children(){
		System.out.println("Children constructor block");
	}
}