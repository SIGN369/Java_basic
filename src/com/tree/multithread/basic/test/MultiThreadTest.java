package com.tree.multithread.basic.test;

import com.tree.multithread.basic.ThreadByExtends;

public class MultiThreadTest {
	/**
	 * ���̷߳�ʽ1������
	 */
	public static void main(String[] args) {
		ThreadByExtends thread1 = new ThreadByExtends();
		ThreadByExtends thread2 = new ThreadByExtends();
		ThreadByExtends thread3 = new ThreadByExtends();
		//���Կ��������߳�
		String tName = thread1.getName();
		String tName2 = thread2.getName();
		String tName3 = thread3.getName();//˳����ô��210
		//ͨ��start�����ڿ���һ���µ��̣߳��µ�ջ��
		thread1.start();//ȥ����run()����
		thread2.start();//ȥ����run()����
		thread3.start();//ȥ����run()����
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}
