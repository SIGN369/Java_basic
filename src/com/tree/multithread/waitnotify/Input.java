package com.tree.multithread.waitnotify;
/**
 * @author zyg
 *
 */
public class Input implements Runnable{
	private Person p;
	//��������ֵ
	public Input(Person p) {
		this.p = p;
	}
	@Override
	public void run() {
		int a =0;
		while (true) {
			synchronized (p) {
				if (p.flag) {
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					if (a % 2 ==0) {
						p.name = "xgx";
						p.age = 15;
					}else{
						p.name = "xp";
						p.age = 99;
					}
					a ++;		
					p.flag = true;
					p.notify();
				}
			}
			
		}
		
	
	}

}
