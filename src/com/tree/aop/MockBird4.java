package com.tree.aop;

import com.tree.aop.common.MockBird;

/**
 * 聚合-has_a
 * @author zyg
 *
 */
public class MockBird4 extends MockBird {
    
	/**
	 * 记录飞行时间--写个儿子来计算fly()时间
	 */
    @Override
    public void fly() {
    	System.out.println("Bird fly start...");
    	super.fly();
        System.out.println("Bird fly end...");
    }
}