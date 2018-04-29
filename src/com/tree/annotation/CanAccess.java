package com.tree.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.RetentionPolicy;
/**
 * 自定义注解:通过 @interface 关键字进行定义
 * @author admin
 * The retention of something is the keeping of it.
 * 
 * 1、元注解
	* 元注解是什么意思呢？
	* 元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面
	* 元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CanAccess {
	/*注解的属性
	注解的属性也叫做成员变量。注解只有成员变量，没有方法。
	注解的成员变量在注解的定义中以“无形参的方法”形式来声明，
	其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
	*/
	String role() default "admin";//默认值为admin
	
}
