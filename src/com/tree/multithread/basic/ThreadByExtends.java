package com.tree.multithread.basic;
/**
 * ��ʽ1��ͨ���̳�����Threadʵ��
 * @author zyg
 *ȱ��û�з���ֵ
 *�������쳣
 *���̳еľ�����
 */
public class ThreadByExtends extends Thread{
	@Override
	public void run() {
		System.out.println("�²����ǵڼ����߳�>��ռִ��"+Thread.currentThread().getName());
	}
}
