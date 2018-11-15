package com.tree.multithread.basic.test;

import com.tree.multithread.basic.LockDemo;

public class LockTest {
		public static void main(String[] args) {
			LockDemo sellTicket = new LockDemo();
			Thread thread1= new Thread(sellTicket,"Window1");
			Thread thread2 = new Thread(sellTicket,"Window2");
			Thread thread3 = new Thread(sellTicket,"Window3");
			
			thread3.start();
			thread2.start();
			thread1.start();
			
		}
}
