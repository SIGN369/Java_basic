package com.tree.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		Array[] arr = new Array[5];
		System.out.println(arr.length);
		//Type int Array in java 
		int[] sort = new int[10000];
		for(int m=0;m<10000;m++) {
			int var =(int) (Math.random()*10000);
			sort[m]=var;
		}
		int[] clone = sort.clone();
		int[] clone2 = sort.clone();
		int[] arrs = new int[]{12,2,1,56,44,10,5,158};
		/**
		 * 2,1,12,44,56,158
		 * 1,2,12,44,56,158
		 */
		String[] strArr = new String[] {"xgx","zyg","xp"};
		char[] chr = new char[] {'a'};
		//bubbleSort 
		/**
		 * 1、确定排序方式：由小到大--大的向右跑
		 * 2、方案：相连的数字对比移动，交换位置，知道右边比左边大位置
		 * 3、每轮冒出一个值
		 */
		long startTime = System.currentTimeMillis();
		for(int i=1;i<sort.length;i++) {
			for(int m=1;m<sort.length-i;m++) {
				if(sort[m-1]>sort[m]) {
					//swap position
					int temp = sort[m];
					sort[m] = sort[m-1];
					sort[m-1] = temp;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("冒泡"+(startTime-endTime)+"毫秒");
		System.out.println(Arrays.toString(sort));
		
		
		
		long sss = System.currentTimeMillis();
		int[] selectionSort = SortUtils.bubbleSort(clone2);
		long ends = System.currentTimeMillis();
		System.out.println("冒泡排序时间"+(sss-ends)+"毫秒");
		//System.out.println(Arrays.toString(selectionSort));
		
		long ss = System.currentTimeMillis();
		int[] select = SortUtils.selectionSort(clone);
		long end = System.currentTimeMillis();
		System.out.println("选择排序时间"+(ss-end)+"毫秒");
		//System.out.println(Arrays.toString(selectionSort));
	}
	
	
}
