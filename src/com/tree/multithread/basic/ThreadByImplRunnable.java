package com.tree.multithread.basic;
/**
 * @author zyg
 *
 */
public class ThreadByImplRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(""+Thread.currentThread().getName());
	}

}
