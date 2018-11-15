package com.tree.algorithm.recursive;

public class Recursive {
	 /**
	  * factorial���׳�
	  * �ݹ飺���ٹ���ջ������
	  * 1.�ݹ�ǰ��--�߽���
	  * 2.�ݹ鷵��--���߽�ʱ
	  * @param i
	  * @return
	  * ԭ��
	  * 	f(5) = 5*f(4); = 5*4*3*2*1//ÿ�ζ���������ڹ���ջ�е���߽��ݹ�Ż�
	  * 	f(4) = 4*f(3); = 4*3*2*1
	  * 	f(3) = 3*f(2); = 3*2*1
	  * 	f(2) = 2*f(1); = 2*1
	  * 	f(1) = 1
	  */
	 static int factorial(int i)
	 {
	 	int sum = 0;
	 	if (0== i)
	 		return (1);
	 	else
	 		System.out.println(i);
	 		sum = i * factorial(i-1);
	 	return sum;
	 }
	 public static void main(String[] args) {
		 int factorial = Recursive.factorial(5);
		 System.out.println(factorial);
	}
}
