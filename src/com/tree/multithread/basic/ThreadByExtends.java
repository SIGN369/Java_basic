package com.tree.multithread.basic;
public class ThreadByExtends extends Thread{
	@Override
	public void run() {
		System.out.println(""+Thread.currentThread().getName());
	}
}
