package com.tree.multithread.waitnotify;

public class Output implements Runnable{
	private Person p;
	public Output(Person p) {
		this.p = p;
	}
	@Override
	public void run() {
		synchronized (p) {
			while (true) {
			if (!p.flag) {
				try {
					p.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println(p.name+"...."+p.age);
				p.flag = false;
				p.notify();
			}
		}
		}
	}

}
