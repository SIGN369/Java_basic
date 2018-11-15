package com.tree.job.written.Y2017;
/**
 * 
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
