package com.tree.generic;
/**
 * About value delivery in java;
 * @author zyg
 * Java中所有的参数传递方式都是值传递，传递的实际上是一份副本
 *
 */
public class ValueDelivery {
	private int v= 15;
	
	public void changeValue(int v,ValueDelivery vo) {
		ValueDelivery vd = new ValueDelivery();
		System.out.println(vo==this);//Two variables share a object in heap.
		vd.v = 88;
		vo.v = v;
		//In here change the pointer to another object that not affect original object.
		vo = vd;
		vo.v = 66;
	}
	/**
	 * Just a copy of args;
	 * @param args
	 */
	public static void main(String[] args) {
		ValueDelivery vo = new ValueDelivery();
		System.out.println(vo.v);
		//Actually only exist one object in heap but two variables in stack they all point to the same object.
		vo.changeValue(25,vo);//'vo' in here  just a copy point to original vo.
		System.out.println(vo.v);
	}
}
