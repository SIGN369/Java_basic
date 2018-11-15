package com.tree.multithread.basic.test;

import com.tree.multithread.basic.ThreadByExtends;

public class MultiThreadTest {
	public static void main(String[] args) {
		ThreadByExtends thread1 = new ThreadByExtends();
		ThreadByExtends thread2 = new ThreadByExtends();
		ThreadByExtends thread3 = new ThreadByExtends();
		String tName = thread1.getName();
		String tName2 = thread2.getName();
		String tName3 = thread3.getName();
		thread1.start();
		thread2.start();
		thread3.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}
