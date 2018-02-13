package com.tree.multithread.basic.test;

import com.tree.multithread.basic.SellTicket2;

/**
 * ��ʼ��Ʊ
 * @author zyg
 *
 */
public class SellTest2 {
		public static void main(String[] args) {
			SellTicket2 sellTicket = new SellTicket2();
			Thread thread1= new Thread(sellTicket,"Window1");
			Thread thread2 = new Thread(sellTicket,"Window2");
			Thread thread3 = new Thread(sellTicket,"Window3");
			//�����߳�
			thread3.start();
			thread2.start();
			thread1.start();
		}
}
