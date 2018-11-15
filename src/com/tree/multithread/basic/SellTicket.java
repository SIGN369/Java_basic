package com.tree.multithread.basic;

public class SellTicket implements Runnable{
	public int ticket = 100;
		@Override
	public void run() {
		while(true) {
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
		public class SellTicketByExtends  extends Thread{
			public   void run() {
				while(true) {
					if(ticket>0) {
						System.out.println(Thread.currentThread().getName()+":  "+(ticket--)+" ticket");
						System.out.println(Thread.currentThread().getName()+"");
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"1");
					}else {
						break;
					}
				}
				/**
				 * �����ظ���ԭ��
				 * 	
				 * 	���ָ�����ԭ���������⣬�����ͷ�CPU��ִ��Ȩ������ֵΪ1ʱ�������̻߳�ͬʱͨ���жϽ������飬������
				 */
			}
		}
	
}
