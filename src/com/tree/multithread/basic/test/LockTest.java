package com.tree.multithread.basic.test;

import com.tree.multithread.basic.LockDemo;

/**
 * ��ʼ��Ʊ
 * @author zyg
 * �����ط���1.�ǲ���ͬһ����
 * 					2.�������Ǹ��ط����Ƿ����������ͬ������
 *sleep()��wait()������
 *	1.sleep����黹�������ͷ�cpu��ʹ��Ȩ
 *  2.wait ��黹����cpu��ʹ��Ȩ
 */
public class LockTest {
		public static void main(String[] args) {
			LockDemo sellTicket = new LockDemo();
			Thread thread1= new Thread(sellTicket,"Window1");
			Thread thread2 = new Thread(sellTicket,"Window2");
			Thread thread3 = new Thread(sellTicket,"Window3");
			
			//���쳣��java.lang.IllegalMonitorStateException�Ƿ��������쳣
			thread3.start();
			thread2.start();
			thread1.start();
			
		}
}
