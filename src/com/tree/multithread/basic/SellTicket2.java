package com.tree.multithread.basic;

/**
 * @author zyg
 *
 */
public class SellTicket2 implements Runnable{
	private int ticket = 100;
	private Object  lock  = new Object();
	@Override
	public void run() {
			while(true) {
				synchronized (lock) {
				if(ticket>0) {
					System.out.println(Thread.currentThread().getName()+":  is Selling the  "+(ticket--)+"th ticket");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}
	}
}
