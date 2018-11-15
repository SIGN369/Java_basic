package com.tree.multithread.basic.test;

import com.tree.multithread.basic.ThreadByImplRunnable;

/**
 * @author zyg
 *
 */
public class Test2Runnable {
	public static void main(String[] args) {
		ThreadByImplRunnable myThread= new ThreadByImplRunnable();
		Thread t1 = new Thread(myThread, "1");
		Thread t2 = new Thread(myThread, "2");
		t1.start();
		t2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
