package com.tree.multithread.waitnotify;

/**
 * 多线程的等待唤醒机制
 * @author admin
 *
 */
public class DemoTest {
	public static void main(String[] args) {
		Person p  =new Person();
		Input in = new Input(p);
		Output out = new Output(p);
		Thread tin = new Thread(in);
		Thread tout = new Thread(out);
		
		tin.start();
		tout.start();
		
	}
}
