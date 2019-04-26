package com.tree.aop;


/**
 * 1、
 * 继承实现调用前后计算时间，这个继承自MockBird4，可以先打印日志在计算时间
 * --继承的局限--会导致类的无限增加
 *  考虑使用聚合方式
 * @author zyg
 *
 */
public class MockBird5 extends MockBird4 {
  
	/**
	 * 获取飞行时间
	 */
    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        super.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
    
    
    /**
     * 使用继承来处理自定义模块，日志与时间
     * @param args
     */
    public static void main(String[] args) {
    	MockBird5 mm = new MockBird5();
    	mm.fly();
	}
}