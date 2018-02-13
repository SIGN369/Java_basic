package com.tree.multithread.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
	private int ticket = 1000;
	//���벢��������   
	private Lock  lock  = new ReentrantLock();//�ٴν���������
			
/**
 * ˼����ʲô�ط�����
 */
	@Override
	public void run() {
		while(true) {
			lock.lock();//��ȡ��
				if(ticket>0) {
					try {
						Thread.sleep(5);
						System.out.println(Thread.currentThread().getName()+":  is selling the  "+(ticket--)+"th ticket");
						//ͨ�����������⣬�ؼ��������ͷ�CPU��ִ��Ȩ
						
					} catch (Exception e) {
						// TODO: handle exception
					}	 finally {
						//�ͷ���
						lock.unlock();
					}
				}else {
					break;
				}
			} 
			}
}
