																										package com.tree.exception;

import org.junit.Test;

/**
 * 测试
 * @author admin
 *
 */
public class ExcpTest {
	@Test
	public void test(){
		try {
			MathUtils.sum(5,0);
		} catch (CustomException e1) {
			e1.printStackTrace();
			String message = e1.getMessage();
			System.out.println(message);
		}
	}
	
}
