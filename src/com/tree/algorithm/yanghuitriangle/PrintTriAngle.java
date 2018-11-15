package com.tree.algorithm.yanghuitriangle;

import java.util.Arrays;

public class PrintTriAngle {
	/**
	 * 打印杨辉三角
	 * ？？
	 * 如何实现？/
	 * @param args
	 */
	public static void main(String[] args) {
		//使用二维数组来实现杨辉三角打印,10行
		int[][] arr = new int[10][10];
		//初始化
		arr[0][0]=1;
		arr[1][0]=1;
		arr[1][1] = 1;
		for(int i=2;i<10;i++) {
			for(int m =0;m<10;m++) {
				if(m==0) {
					arr[i][0] = 1;
				}else if(m==i) {
					arr[i][i] = 1;
					continue;
				}else {
					arr[i][m] = arr[i-1][m-1]+arr[i-1][m];
				}
			}
		}
		//增强For循环还是可以，怎么就不知道变通
		//这样打印出来的杨辉三角不对不是金字塔形状
	/*	for(int[] arrr:arr) {
			System.out.println(Arrays.toString(arrr));
		}*/
		
		//为了打印出金字塔形状使用空格来填充
		for(int i=0;i<arr.length;i++) {
			//每一行打印length/2-i个空格
			for(int m=0;m<arr.length-i;m++) {
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {
				System.out.print(arr[i][k]+"  ");
			}
			System.out.println("");
		}
		
	}
}
