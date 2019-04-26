package com.tree.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.tree.aop.common.MockBird;


/**
 * 自定义调用逻辑
 * @author zyg
 *
 */
public class TimeCountInvocationHandler implements InvocationHandler {
	private MockBird bird;
	public TimeCountInvocationHandler(MockBird bird) {
        this.bird = bird;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("run")) {//可以写入判断注解的处理逻辑
			System.out.println("这个方法不用代理，因为没有打注解");
		}
		 long start = System.currentTimeMillis();
		 System.out.println("开始了");
	        //每一个子类中计算时间
		 	method.invoke(bird, args);
	        
	        long end = System.currentTimeMillis();
	        System.out.println("结束了");
	        System.out.println("Fly time = " + (end - start));
	        return proxy;
	}

}
