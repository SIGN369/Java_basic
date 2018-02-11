package com.tree.exception;

public class MathUtils {
	
	/**
	 * 使用定义的异常载体类
	 * @param m
	 * @param n
	 * @return
	 * @throws CustomException
	 */
	public static int sum(int m,int n) throws CustomException{
		if(n==0){
			throw new CustomException("by Zero");//按条件抛出异常
		}
		return m/n;
	}
}
