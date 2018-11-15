package com.tree.multithread.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
	private int ticket = 1000;
	private Lock  lock  = new ReentrantLock();
			
	@Override
	public void run() {
		while(true) {
			lock.lock();
				if(ticket>0) {
					try {
						Thread.sleep(5);
						System.out.println(Thread.currentThread().getName()+":  is selling the  "+(ticket--)+"th ticket");
					} catch (Exception e) {
					}	 finally {
						lock.unlock();
					}
				}else {
					break;
				}
			} 
			}
}
