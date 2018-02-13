package com.tree.job.written.Y2017;

import org.junit.Test;

/**
 * ���������
 * @author zyg
 *
 */
public class Written {
	@Test
		public void StringTest() {
			String a = "Hello";
			String b= "Hello";
			String c = new String("Hello");
			System.out.println("a==b"+a==b);//false�Ƚϵ��ǵ�ַ
			System.out.println("a==c"+a==c);//false�Ƚϵ��ǵ�ַ
			System.out.println("c.equal(Hello)"+c.equals("Hello"));//true
		}
	@Test
	public void DataRange() {
		/**byte 8bit
		 * short 16bit
		 * int 32 bit
		 * long 32bit
		 * float 32bit
		 * double 64bit
		 * 1��
�������ͣ�int ������λ����32
��װ�ࣺjava.lang.Integer
��Сֵ��Integer.MIN_VALUE= -2147483648 ��-2��31�η���
���ֵ��Integer.MAX_VALUE= 2147483647  ��2��31�η�-1��
2��
�������ͣ�short ������λ����16
��װ�ࣺjava.lang.Short
��Сֵ��Short.MIN_VALUE=-32768 ��-2��15�˷���
���ֵ��Short.MAX_VALUE=32767 ��2��15�η�-1��
3��
�������ͣ�long ������λ����64
��װ�ࣺjava.lang.Long
��Сֵ��Long.MIN_VALUE=-9223372036854775808 ��-2��63�η���
���ֵ��Long.MAX_VALUE=9223372036854775807 ��2��63�η�-1��
4��
�������ͣ�float ������λ����32
��װ�ࣺjava.lang.Float
��Сֵ��Float.MIN_VALUE=1.4E-45 ��2��-149�η���
���ֵ��Float.MAX_VALUE=3.4028235E38 ��2��128�η�-1��
5��
�������ͣ�double ������λ����64
��װ�ࣺjava.lang.Double
��Сֵ��Double.MIN_VALUE=4.9E-324 ��2��-1074�η���
���ֵ��Double.MAX_VALUE=1.7976931348623157E308 ��2��1024�η�-1��

		 */
	}
	@Test
	public void MathTest() {
		float x = 1,y=2,z=3;
		//����
	//	System.out.println(z--/++x);//������++i��i++������������Ⱥ��ұ��ǣ�++i���Լ�1�ڸ�ֵ��i++�ظ�ֵ���Լ�1������õ�1.5
		System.out.println(y+=z--/++x);//3.5��ע��++i����д������д���ڵ�ʽ�е���������
	}
}
