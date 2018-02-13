package com.tree.multithread.deadlock;
//��������B
public class LockB {
	private LockB(){}
	public final static LockB lockB = new LockB();
}
