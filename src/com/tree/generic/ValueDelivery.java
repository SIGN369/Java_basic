package com.tree.generic;
/**
 * About value delivery in java;
 * @author zyg
 *
 */
public class ValueDelivery {
	private int v= 15;
	
	public void changeValue(int v,ValueDelivery vo) {
		ValueDelivery vd = new ValueDelivery();
		vd.v = v;
		vo = vd;
	}
	/**
	 * Just a copy of args;
	 * @param args
	 */
	public static void main(String[] args) {
		ValueDelivery vo = new ValueDelivery();
		System.out.println(vo.v);
		vo.changeValue(25,vo);
		System.out.println(vo.v);
	}
}
