package com.tree.multithread.basic;

/**
 * ˼�����ļ������⣬һ���߳������ͻ�ִ�����Ӧ����죬Ȼ��黹Կ�ף��ٴ�����
 * @author zyg
 *
 */
public class SellTicket2 implements Runnable{
	private int ticket = 100;
	private Object  lock  = new Object();//������������һ����ʶ
	@Override
	public void run() {
		//��һ����
			//��������Ʊ�ͼ�����
		//synchronized (lock) {//д������ֻ��һ���߳�ִ�У�һ���̻߳�ִ����
			while(true) {
				synchronized (lock) {
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
	}
}
