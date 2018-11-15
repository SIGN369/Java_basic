package com.tree.abstr;
/**
 * 接口：
 * 			1、接口中的属性--final   --默认public static final
 * 			2、方法
 * @author zyg
 *
 */
public interface Tree {
		public static final String name ="IROBOT";//为了安全--想想实现了这个接口的其中一个修改了这个属性--其它实现者的值也改变了--恐怖
		
		void guessAgeByName(String name);
}
