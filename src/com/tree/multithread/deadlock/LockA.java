package com.tree.multithread.deadlock;
//��a������ģʽ
public class LockA {
	private LockA(){}
	public final static LockA lockA = new LockA();
}
