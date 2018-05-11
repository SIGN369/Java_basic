package com.tree.algorithm.sort;

import java.util.Arrays;

public class SortUtils {
	/**
	 * ѡ������
	  * ���ɷ�ʣ��߼�û���⣬������ѭ���ﶨ���������ȡ�������ֵ��������
	  * ��Զ���᳤����
	  * @param arr
	  * @return
	  */
	  public static int[] selectionSort(int[] arr){
		  int index = 0;//��¼��������Ҫ����ѭ���ﶨ�����
			for(int i=0;i<arr.length;i++){
				int min= arr[i];
				if(i>0){
				//�ڶ���ѭ����ʼʱ������λ��,�����һ�ν������
					int tmp=arr[i-1];
					arr[i-1] = arr[index];
					arr[index] = tmp;
				}	
			  for(int m =i;m<arr.length;m++){
				if(arr[m]<min){//���С����Сֵ����Сֵת��
					min = arr[m];
					index=m;
					}	
				}
				}
				return arr;
			}
	  /**
	   * ð������
	   * @param arr
	   * @return
	   */
	  public static int[] bubbleSort(int[] arr){
			for(int i=0;i<arr.length-1;i++){
			  for(int m =0;m<arr.length-i-1;m++){
				if(arr[m]>arr[m+1]){
					int tmp=arr[m];
					arr[m] = arr[m+1];
					arr[m+1] = tmp;
					}				
				}
				}
			return arr;
			}
	  public static void main(String[] args) {
			//System.out.println(recursive(5));
		  	System.out.println(Arrays.toString(selectionSort(new int[] {8,52,85,3,65,12,50}))+"����ð�������");
			System.out.println(Arrays.toString(bubbleSort(new int[] {8,52,85,3,65,12,50}))+"����ѡ�������");
			
		}
}
