package com.tree.multithread.basic.test;

import com.tree.multithread.basic.SellTicket;

/**
 * ��ʼ��Ʊ
 * @author zyg
 *
 */
public class SellTest {
		public static void main(String[] args) {
			SellTicket sellTicket = new SellTicket();
			//�����߳�
			Thread thread1= new Thread(sellTicket,"Window1");
			Thread thread2 = new Thread(sellTicket,"Window2");
			Thread thread3 = new Thread(sellTicket,"Window3");
			
			//�����߳�
			thread1.start();
			thread2.start();
		    thread3.start();
			
		}
}
