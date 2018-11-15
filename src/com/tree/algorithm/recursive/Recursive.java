package com.tree.algorithm.recursive;

public class Recursive {
	 /**
	  * factorial���--recursice consist of two part 
	  * 		1、forward
	  * 		2、backward
	  * 	f(5) = 5*f(4); = 5*4*3*2*1
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
	 
	 /**
	  * Create user menu tree via recursive.
	  * @return
	  */
	 public String generateUserMenuTree() {
		 return "";
	 }
}
