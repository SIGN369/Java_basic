package com.tree.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.tree.aop.common.Flyable;
import com.tree.aop.common.MockBird;

/**
 * 模拟生成代理类
 * @author zyg
 * 接口好处--方便代理，就是生成了一个加强版的类，而且还是同一个接口体系下的，可以直接替换
 *
 */
public class BirdDynamicProxy implements Flyable {
    private InvocationHandler invocaitonHandler;
    //导入示例，非来自继承
    public BirdDynamicProxy(InvocationHandler invocaitonHandler) {
        this.invocaitonHandler = invocaitonHandler;
    }

    
    	
   /**
    * 静态代理：
    *  如果同时代理多个类，依然会导致类无限制扩展
    * 如果类中有多个方法，同样的逻辑需要反复实现
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
        try {
    	        Method method =Flyable.class.getMethod("fly");
					this.invocaitonHandler.invoke(this, method, null);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }

@Override
public void run() {
	try {
        Method method =Flyable.class.getMethod("run");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

@Override
public void climb() {
	try {
        Method method =Flyable.class.getMethod("climb");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

@Override
public void jump() {
	try {
        Method method =Flyable.class.getMethod("jump");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

@Override
public void shout() {
	try {
        Method method =Flyable.class.getMethod("shout");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

@Override
public void weep() {
	try {
        Method method =Flyable.class.getMethod("weep");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

@Override
public void smile() {
	try {
        Method method =Flyable.class.getMethod("smile");
			this.invocaitonHandler.invoke(this, method, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static void main(String[] args) {
	MockBird flyable = new MockBird();
	BirdDynamicProxy mm = new BirdDynamicProxy(new TimeCountInvocationHandler(flyable));
	mm.fly();
	mm.run();
	mm.shout();
	mm.smile();
	mm.jump();
	mm.weep();
}
}