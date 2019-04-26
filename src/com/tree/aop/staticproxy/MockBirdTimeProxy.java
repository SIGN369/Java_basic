package com.tree.aop.staticproxy;

import com.tree.aop.common.Flyable;

/**
 * 静态代理类
 * 聚合-has_a
 * @author zyg
 *
 */
public class MockBirdTimeProxy implements Flyable {
    private Flyable flyable;
    //导入示例，非来自继承
    public MockBirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

   /**
    * 静态代理：
    *  如果同时代理多个类，依然会导致类无限制扩展
    * 如果类中有多个方法，同样的逻辑需要反复实现--如以下的方法
    * 
    * 动态代理
    * 继续回到上面这个问题：是否可以使用同一个类（例如：TimeProxy）来计算任意对象的任一方法的执行时间呢
    * 对象，和方法作为代理的变量，再每个方法的调用前后切入编程
    * 
    * 作用非常大，在很多底层框架中都会用得到，比如struts，Spring等都用到了动态代理，它的作用很简单，就是将你要使用的类，
    * 重新生成一个子类或本类，这样框架就可以利用这个新生成的类做一些事情，比如在该类的方法前后加一些代码。。
		这样的话，你想像一下，你是不是不用修改任何已经编写好的代码，只要使用代理就可以灵活的加入任何东西，将来不喜欢了，
		不用也不会影响原来的代码
    */
    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }

    @Override
    public void run() {
    	  long start = System.currentTimeMillis();
          flyable.run();
          long end = System.currentTimeMillis();
          System.out.println("Fly time = " + (end - start));
	
    }

@Override
public void climb() {
	  long start = System.currentTimeMillis();
      flyable.climb();
      long end = System.currentTimeMillis();
      System.out.println("Fly time = " + (end - start));
	
}

@Override
public void jump() {
	  long start = System.currentTimeMillis();
      flyable.jump();
      long end = System.currentTimeMillis();
      System.out.println("Fly time = " + (end - start));
	
}

@Override
public void shout() {
	  long start = System.currentTimeMillis();
      flyable.shout();
      long end = System.currentTimeMillis();
      System.out.println("Fly time = " + (end - start));
	
}

@Override
public void weep() {
	  long start = System.currentTimeMillis();
      flyable.weep();
      long end = System.currentTimeMillis();
      System.out.println("Fly time = " + (end - start));
	
}

@Override
public void smile() {
	  long start = System.currentTimeMillis();
      flyable.smile();
      long end = System.currentTimeMillis();
      System.out.println("Fly time = " + (end - start));
	
}
}