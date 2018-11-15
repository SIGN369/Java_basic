package com.tree.initorder;
/**
 * 实践：
 * 	java中类的初始化顺序
 * 	父类静态初始化代码块--子类静态初始化代代码块--父类初始化块-父类构造块--子类初始化块-子类构造块
 * 类加载机制：
 * 			java--先将编译号的class文件加载到内存中，存放到方法区中，后续的实例化对象按照class信息创建对象
 * 					--静态代码块先于非静态代码块？？静态块编译后完成--非静态实例化触发【静态】
 * 					--所以静态 代码块不能够调用非静态代码块
 * @author zyg
 *
 */
public class Parent {
	static {
		System.out.println("Parent static block--");
	}
	{
		System.out.println("Parent block");
	}
	public Parent(){
		System.out.println("Parent constructor block");
	}
	/** order as the following:(as follow)
	 * Parent static block--
		Children static block--
		Parent block
		Parent constructor block
		Children block
		Children constructor block
			 * @param args
	 */
	public static void main(String[] args) {
		//Parent parent = new Parent();
		Children children  = new Children();
		
	}
}
