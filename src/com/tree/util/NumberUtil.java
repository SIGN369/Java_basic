package com.tree.util;

/**
 * 数字工具
 * @author tngou@tngou.net
 *
 */
public class NumberUtil {

	/**
	 * 取得数据值 中 第几位的值
	 * @param num
	 * @param digit
	 * @return
	 */
	public int digitNum(int num,int digit) {
		return (int) (num%(int) Math.pow(10,digit)/Math.pow(10,digit-1));
	}
	
	
}
