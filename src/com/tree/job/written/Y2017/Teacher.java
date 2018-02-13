package com.tree.job.written.Y2017;
/**
 * ������һ������Ҫ�Ĺ�ϵ
 * �����ӹ�ϵ������һ����дֻ����ô�������о�ֻ������д��һ������
 * ����ʵ����ʱ����ķ�������д�ˣ����ڷ���ȡ�о�ֻ�б��ص��Ǹ�����
 * ����ػ��ƣ�����class�ļ�--����->��ʼ��->�����ڴ�class���� �����Ƿ����ˣ����ؽ����ǽ�����Ϣ�洢�ڷ��������������Ϣ����ͬʱ���ʼ����̬����ģ�飬���뷽������static����
 * 						�Ĵ���������ڶ�����ڵģ�������ؽ����ڴ��к��൱��������һ��ģ�壬ʵ��������������ɴ˸�����Ϣ�������ڴ棬������֪��
 * 						�ڴ���ֻ��һ��class ����󣬵��ǿ����жԹ�ʵ��������
 * @author zyg
 *
 */
public class Teacher extends Person {
public Teacher() {
	super();
}
public Teacher(int a) {
	System.out.println(a);
}
public void fun() {
	System.out.println("2");
}
public static void main(String[] args) {
	Person teacher = new Teacher();
	Person teacher2 = new Teacher(3);
	
}
}
