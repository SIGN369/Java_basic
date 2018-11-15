package com.tree.multithread.deadlock;
public class LockA {
	private LockA(){}
	public final static LockA lockA = new LockA();
}
