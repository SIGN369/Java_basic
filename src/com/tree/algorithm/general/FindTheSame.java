package com.tree.algorithm.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 关于数组的算法题目
 * @author zyg
 *
 */
public class FindTheSame{
	/**
	 * 统计数组中重复的值，并按照所给的案例输出
	 * 	值：6,位于：3,4
	* 	值：8,位于：2,5,9
	* 	值：9,位于：0,6,7,8
	 * @param args
	 */
	public static void main(String[] args){
		//统计一个数组中说有重复的数字
		int[] arr = new int[10];
		for(int i=0;i<10;i++){
			arr[i]=(int)((Math.random()+1)*5);
		}
		//强制转换发生在小转大时候
		System.out.println(Arrays.toString(arr));
		Map map = new HashMap();
		//找出相同的数
		for (int i=0;i<arr.length ;i++ ) {
			String key = "";
			String value = "";
			int present = arr[i];
			for (int m=0; m<arr.length;m++ ) {
				//map的containsKey()方法判断是否存在key
				if(i!=m&&!map.containsKey(arr[i])&&present==arr[m]){
					//字符串拼接，使用""，哈哈
					key = ""+present;
					value+=(m+",");
				}
			}
			//还要加上当前位置
			if(value!="") {
				value+=(i+"");
			}
			if(key!=""){
				map.put(key,value);
			}
		}
		//keySet()方法，注意不是属性
		for(Object  k:map.keySet()) {
			System.out.println("值："+k.toString()+",位于："+map.get(k));
		}
	}
}
