package com.tree.exception;

import org.junit.Test;

import com.seeyon.apps.wuxicityGdocExchange.test.ArgumentsException;
import com.seeyon.apps.wuxicityGdocExchange.test.MathUtils;

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
		} catch (ArgumentsException e1) {
			e1.printStackTrace();
			String message = e1.getMessage();
			System.out.println(message);
		}
	}
	
}
