package com.tree.multithread.deadlock;

public class DeadThread implements Runnable{

	
	public void run() {
		int i = 0;
		while (true) {
			/*
			 * 线程的抢占
			 */
			if (i % 2 ==0) {
				//拿到A锁
				synchronized (LockA.lockA) {
					System.out.println("if...拿到A锁啦");
					//拿到B锁
					synchronized (LockB.lockB) {
						System.out.println("if...拿到B锁啦");
					}
				}
			}else{
				synchronized (LockB.lockB) {
					System.out.println("else..拿到B锁");
					synchronized (LockA.lockA) {
						System.out.println("else...拿到A锁");
					}
				}
			}
			i ++;

	}
	}
}
