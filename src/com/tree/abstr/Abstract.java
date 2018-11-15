package com.tree.abstr;
/**
 * 关于抽象
 * @author zyg
 *
 */
public abstract class Abstract {
	private String name;//properties
	/**
	 * Abstract method as the following one.
	 */
	public abstract void fun();
	/**
	 * Define general method in abstract class.
	 * @param m
	 * @return
	 */
	public int funT(int m) {
		return m*m;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
