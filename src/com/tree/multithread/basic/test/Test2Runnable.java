package com.tree.multithread.basic.test;

import com.tree.multithread.basic.ThreadByImplRunnable;

/**
 * ����Ȼ��ʵ�� run ������Ȼ�󴴽�Runnable��������󣬴��뵽ĳ���̵߳Ĺ��췽���У������߳�
 * @author zyg
 *
 */
public class Test2Runnable {
	public static void main(String[] args) {
		ThreadByImplRunnable myThread= new ThreadByImplRunnable();
		//�����̹߳��췽������ʼִ��
		Thread t1 = new Thread(myThread, "�Ҷ�����߳�1");
		Thread t2 = new Thread(myThread, "�Ҷ�����߳�2");
		t1.start();
		t2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
			try {
				//����10����
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
