package com.tree.aop.common;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * 被代理对象，初始类，需要计算方法的执行时间，就是飞行时间
 * ；；实现目标，调用代理计算每个方法的执行时间
 * @author zyg
 *
 */
public class MockBird implements Flyable {

	@Override
	public void fly() {
		System.out.println("MockBird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MockBird is running...");
		  try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void climb() {
		// TODO Auto-generated method stub
		System.out.println("MockBird is climbing...");
		  try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
				System.out.println("MockBird is jumping...");
				  try {
			            Thread.sleep(new Random().nextInt(1000));
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
		
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("MockBird is shoutping...");
		  try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void weep() {
		// TODO Auto-generated method stub
		System.out.println("MockBird is weeping...");
		  try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		System.out.println("MockBird is smiling...");
		  try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		Class dd=MockBird.class;
		Method[] declaredMethods = dd.getDeclaredMethods();
		//给出动态生成代理，应用场景训练
		//注解
		
	}
}
