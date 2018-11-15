package com.tree.algorithm.sort;

import java.util.Arrays;
import org.junit.Test;
/**
 * Java ��  int a,b;  -->a/b 
 * 								
 */

/**
 * algorithm of sort
 * 1.bubble sort
 * 2.insertion sort
 * 3.selection sort
 * @author zyg
 *
 */
public class Insertion_sort {
	int srcArray[];
	int[] arr0 = new int[] {};
	int[] arr1= {}; 
	int arrays[] = new int[10];
	@Test
	public  void authenticInsertSort() {
		 double a =  (3/2.00);
		 double b =  (3.0/2);
		 System.out.println(a);
		int[] num = new int[10000];
		for(int i=0;i<10000;i++) {
			int random = (int) (Math.random()*99999);
			num[i] = random;
		}
		long   begin=System.currentTimeMillis();
			for(int i=1;i<num.length;i++) {
				int key = num[i];
				int j = i-1;
				 while(j>=0&&num[j]>key) {
					 num[j+1] = num[j];
					 j--;
				 }
				 num[j+1] = key;
			}
			long   end=System.currentTimeMillis();
			System.out.println("Time elapsed:"+(end-begin));
	}
	/**
	 * 2.insertion sort
	 */
	@Test
	public void insertionSort() {
		int[] num = new int[10000];
		for(int i=0;i<10000;i++) {
			int random = (int) (Math.random()*99999);
			num[i] = random;
		}
		long   begin=System.currentTimeMillis();
		for(int i=1;i<num.length;i++) {
				for(int m=i;m>0;m--) {
					if(num[m]<num[m-1]) {
						int tmp=num[m];
						num[m]=num[m-1];
						num[m-1] = tmp;
					}else {
						break;
					}
				}
		}
		long   end=System.currentTimeMillis();
		System.out.println("Time elapsed:"+(end-begin));
		System.out.println(Arrays.toString(num));
	}
	
	
}
