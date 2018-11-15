package com.tree.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;

public class MathUtils {

		/**
		 * 保留 bit 位小数点
		 * @param vo
		 * @param bit
		 * @return
		 */
		public static Double getDouble(Double vo,int bit) {
			BigDecimal bg = new BigDecimal(vo);
	        double f1 = bg.setScale(bit, BigDecimal.ROUND_HALF_UP).doubleValue();
	        return f1;
		}
		
		
		/**
		 * 生成时间线、索引、默认数据
		 * @param indexs
		 * @param defaults
		 * @return
		 */
		public static JSONArray generateTimeLine(Map<String,Object> indexs,JSONArray defaults) {
			JSONArray jsonArr = new JSONArray();
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH);//当前月份的上一个月
			int year = cal.get(Calendar.YEAR);
			int previous = cal.get(Calendar.YEAR)-1;
			int diff = 12-month;
			int offset = month+1;
			
			//生成默认数据
			for(int u=0;u<12;u++) {
				defaults.add(0);
			}
			if(month==12) {
				String key = "";
				for (int i = 0; i < 12; i++) {
						if(i<10) {
							key = year+"-0"+i;
							indexs.put(key, i);
						}else {
							key = year +"-"+i;
							indexs.put(key, i);
						}
						jsonArr.add(key);
				}
			}else {
					//Last year.
					for(int m=0;m<diff;m++) {
						String key = "";
						if(offset<10) {
							key = previous+"-0"+offset;
							indexs.put(key, m);
						}else {
							key = previous +"-"+offset;
							indexs.put(key, m);
						}
						jsonArr.add(key);
						offset++;
					}
					//This year.
					for(int k=1;k<=month;k++) {
						String key = "";
						if(k<10) {
							key = year+"-0"+k;
							indexs.put(key, diff+k-1);
						}else {
							key = year +"-"+k;
							indexs.put(key, diff+k-1);
						}
						jsonArr.add(key);
					}
			}
			return jsonArr;
		}
		
		public static JSONArray initYearArr(int lenght) {
			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < lenght; i++) {
				jsonArr.add(0);
			}
			return jsonArr;
		}
		//查询月份缺省数据--看看如何做
		public static JSONArray generateMonth(Map<String,Object> indexs,int num) {
			JSONArray jsonArr = new JSONArray();
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH)+1;
			int year = cal.get(Calendar.YEAR);
			int previous = cal.get(Calendar.YEAR)-1;
			//生成时间线--配置产生\--1、是否是本年  2、是否跨年份 3、是否是小于10
			boolean isCurrentYear = month-num>=0;
			int offset = month -num+1;
			if(isCurrentYear) {
				int index = 0;
				for (int i = offset; i <=month; i++) {
					String key = "";
						if(i<10) {
							key = year+"-0"+i;
						}else {
							key = year+"-"+i;
						}
						jsonArr.add(key);
						indexs.put(key, index);
						index++;
				}
			}else {
				//分两段-过去、现在
				int off = 12-(num-month)+1;
				int index = 0;
				for (int i = off; i<=12; i++) {
					String key = "";
					if(i<10) {
						key = previous+"-0"+i;
					}else {
						key =previous+ "-"+i;
					}
					jsonArr.add(key);
					indexs.put(key, index);
					index++;
				}
				//第二段
				int ind = num-month-1;
				for (int i = 1; i<=month; i++) {
					String key = "";
					if(i<10) {
						key = year+"-0"+i;
					}else {
						key =year+ "-"+i;
					}
					jsonArr.add(key);
					indexs.put(key, ind);
					ind++;
				}
			}
			return jsonArr;
		}
		
		public static void init(JSONArray arr,int length){
			for (int i = 0; i < length; i++) {
				arr.add(0);
			}
		}
}
