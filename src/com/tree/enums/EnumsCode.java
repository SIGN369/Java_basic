package com.tree.enums;

/**
 * 枚举接口
 * 注意枚举是线程不安全的不要用来传递参数或记录状态
 * 枚举是常量值--共享使用
 * @author zyg
 *
 */
public interface EnumsCode {
	String getValue();

	String getText();
}

