package com.tree.multithread.basic.test;

import com.tree.multithread.basic.SellTicket;

/**
 * Java中属性访问都是通过get/set方法
 * 载Python张直接打点就可以访问：
 * >>>father = Father("xgx",90)
 * >>>name = father.name
 * python中不管时属性，方法（函数）打点都会给提示，提示时类，函数，或者其它，不会报错
 * @author zyg
 *
 */
public class SellTest {
		public static void main(String[] args) {
			//Target
			SellTicket sellTicket = new SellTicket();
			//target,ThreadName
			Thread thread1= new Thread(sellTicket,"Window1");
			Thread thread2 = new Thread(sellTicket,"Window2");
			Thread thread3 = new Thread(sellTicket,"Window3");
			
			//Begin Thread
			thread1.start();
			thread2.start();
		    thread3.start();
			
		}
}
