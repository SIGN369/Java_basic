package com.tree.aop.staticproxy;

import com.tree.aop.common.Flyable;
import com.tree.aop.common.MockBird;

/**
 * 2、
 * 日志类
 * @author zyg
 *聚合替代继承
 */
public class BirdLogProxy implements Flyable {
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }
    
    /**
     * 聚合解决方案：
     * 			持有-has_a
     * 			用来替代继承的局限性
     * @param args
     */
    public static void main(String[] args) {
    	//1、先打印日志，再计算飞行时间
			MockBird mb = new MockBird();
	        BirdLogProxy p1 = new BirdLogProxy(mb);
	        MockBirdTimeProxy p2 = new MockBirdTimeProxy(p1);
	        p2.fly();
	   //2、在计算飞行时间前后打印日志
	        
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void climb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		
	}
}
