package com.tree.multithread.basic;
/**
 * ��ʽ2��ͨ��Runnable�ӿ���ʵ�ֶ��߳�
 * @author zyg
 *
 */
public class ThreadByImplRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("����Runnable�����ˣ�>��ռִ��"+Thread.currentThread().getName());
	}

}
