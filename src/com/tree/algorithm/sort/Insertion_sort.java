package com.tree.algorithm.sort;

import java.util.Arrays;
import org.junit.Test;
/**
 * Java ��  int a,b;  -->a/b ��Ҫ�ǿ���ĸ���������ͣ��������������
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
	/*
	 * ����Ķ��巽ʽ
	 */
	int srcArray[];
	int[] arr0 = new int[] {};
	int[] arr1= {}; 
	int arrays[] = new int[10];
	/**
	 * ����һ�����ڵĲ�������˼��
	 * 				�ͺʹ���һ��ÿ�γ�һ���ƣ��������飬
	 * 				ע�⣺���ų鵽���ƾ������������������ӵ�����������Ҳ����������
	 */
	@Test
	public  void authenticInsertSort() {//���ٲ���Ҫ��Ų����Ч����Ȼ�ܸ�
		 double a =  (3/2.00);//����������ĸΪ2.0�����--1.5
		 double b =  (3.0/2);//�����������Ϊ����=1
		 System.out.println(a);
		int[] num = new int[10000];
		for(int i=0;i<10000;i++) {
			int random = (int) (Math.random()*99999);//����0~99998֮��������
			num[i] = random;
		}
		long   begin=System.currentTimeMillis();
			for(int i=1;i<num.length;i++) {
				//��ȡ�鵽���ƣ��ȱ������ҵ�����λ���ڲ���,һ�κ����е��Ʊȴ�С
				int key = num[i];
				//����һ������,�������Ƚ�ʱ
				int j = i-1;
				 while(j>=0&&num[j]>key) {//���鵽����С�����ʱ����ߵ��������ƶ�,һֱ������������ֹͣ
					 num[j+1] = num[j];
					 j--;
				 }
				 //���鵽���Ʋ���
				 num[j+1] = key;
			}
			long   end=System.currentTimeMillis();
			System.out.println("����ʱ��"+(end-begin));
			System.out.println(Arrays.toString(num)+"����"+num.length);
	}
	/**
	 * ����������������Ĺ����㷨-Ч�ʼ���ף������㷨
	 * 			˼·��ÿһ�ζ�ȥ������ȥ����Ҫ������Ǹ�����Ȼ��һֱһֱ�ƶ���һֱ�����ұߴ�Ϊֹ
	 * 2.insertion sort
	 */
	@Test
	public void insertionSort() {//ÿһ�ζ�Ҫ����Ҫ�ƶ����Ǹ���Ч����Ȼ����
		//ʹ����������ɳ���Ϊ1000������,Math.random();��0~1֮�䣬����ҿ�
		//��ͨ�����ȶ��峤���ڸ�ֵ
		int[] num = new int[10000];
		for(int i=0;i<10000;i++) {
			int random = (int) (Math.random()*99999);//����0~99998֮��������
			num[i] = random;
		}
		long   begin=System.currentTimeMillis();
		/*
		 * 1.��С��������
		 * 2.����߿�ʼ������Ƚ�������ұ߱����С�ͽ���λ�ã�һֱ����������ߵ��ұ�Сʱ����ѭ��
		 * 3.������ڵ�����ߣ�����
		 */
		//����������
		for(int i=1;i<num.length;i++) {
				//�ڲ��жϴ�С���ƴ���,�����ƶ�λ�ã�һֱ����������
				for(int m=i;m>0;m--) {
					System.out.printf("��i=%d,�ֵ�m=%d��",i,m);
					System.out.println("");
					if(num[m]<num[m-1]) {
						//��ˮ
						int tmp=num[m];
						num[m]=num[m-1];
						num[m-1] = tmp;
					}else {
						//�������������������ֱ�ӹ���,ʡ����������ж�
						//m=0;ֱ��break�������ˣ���=0̫Low�ˣ���������
						break;
					}
				}
				//System.out.println(Arrays.toString(num));
		}
		long   end=System.currentTimeMillis();
		System.out.println("����ʱ��"+(end-begin));//����ʱ��Ϊ6�������15����Millis
		System.out.println(Arrays.toString(num));
		/**1
			i=1--->��һ��forѭ������ִ�У�!!�������������⣬���������������㣬m>0,��һ�������Ϊ0���ڲ㲻����϶�����ִ�С���
		 */
	}
	
	
}
