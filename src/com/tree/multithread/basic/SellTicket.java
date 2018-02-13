package com.tree.multithread.basic;


/**
 * ���߳���Ʊʵ��
 * 
 * @author zyg
 *
 */
public class SellTicket implements Runnable{
 //100��Ʊ,�����ڳ�Ա������ÿ�ζ������ֻ����һ��ֵ��ͨ�����߳����߲��ܿ�������
	private int ticket = 100;
	/**
	 * ��Ʊ����
	 */
		@Override
	public void run() {
		while(true) {
			if(ticket>0) {
				System.out.println(Thread.currentThread().getName()+":  is Selling the  "+(ticket--)+"th ticket");
				try {
					//ͨ�����������⣬�ؼ��������ͷ�CPU��ִ��Ȩ
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				break;
			}
		}
	}
		/**
		 * �̳�ʵ����Ʊ
		 * @author zyg
		 *
		 */
		public class SellTicketByExtends  extends Thread{
			@Override//synchronized���η����ﵽͬ��Ч��
			public   void run() {
					//��������Ʊ�ͼ�����
				while(true) {
					if(ticket>0) {
						System.out.println(Thread.currentThread().getName()+":  ��������"+(ticket--)+"�� ticket");
						System.out.println(Thread.currentThread().getName()+"����������");
						try {
							//ͨ�����������⣬�ؼ��������ͷ�CPU��ִ��Ȩ
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						//��һ��Ϊʲô����ӡ����
						System.out.println(Thread.currentThread().getName()+"������");
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
