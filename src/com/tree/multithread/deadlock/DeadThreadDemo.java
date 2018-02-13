package com.tree.multithread.deadlock;

public class DeadThreadDemo {
	public static void main(String[] args) {
		DeadThread dt = new DeadThread();
		Thread t1 = new Thread(dt);
		Thread t2 = new Thread(dt);
		
		//开启线程
		t1.start();
		t2.start();
		/**
			 * 结果分析：
			 * if...拿到A锁啦
			 *if...拿到B锁啦
			 *
			if...拿到A锁啦
			else..拿到B锁     这里发生了错乱,if所属线程拿到A锁，还没执行完，下一个线程就进来了，走到else部分有拿到一个B锁，由于是单例模式，
				这时候A锁已经被占有，继续下一步好是需要A锁，由获取不到，就会造成错乱锁死
		 */
	}
}
