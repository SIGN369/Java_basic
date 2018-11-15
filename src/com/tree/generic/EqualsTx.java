package com.tree.generic;
/**
 * Differentiate equal and ==;
 * 1、basic data type
 * 2、Object data type
 * @author zyg
 *
 */
public class EqualsTx {
	public EqualsTx() {
		
	}
	/**
	 * 1、SO for ==:
	 * 			Compare value in case of  basic data type.
	 * 			Compare storage address in case of  wrap object data type.
	 * 	  2、 for equals:
	 * 		      Depend on the invoked class whether has overridden original method,equals(),which defined in Object;
	 * @param args
	 */
	public static void main(String[] args) {
		EqualsTx a = new EqualsTx();
		EqualsTx b = new EqualsTx();
		int m = 656;
		int n= 962;
		Integer mx = 656;
		Integer yx = 656;
		Integer nx = 962;
		System.out.println(a==b);//Compare value in case of  basic data type.
		System.out.println(m==mx);
		System.out.println(yx==mx);//Compare storage address in case of  wrap object data type.
		System.out.println(mx.equals(yx));//Compare value caused it has overrided original method ;
		/*
		 * if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
		 */
		
	}
}
