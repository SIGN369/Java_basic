package com.tree.util;

import java.util.HashMap;
import java.util.Map;

import com.bgs360.pojo.POJO;

public class BuildingUtil {

	/**
	 * 通过名称查询是否存在
	 * @param bean
	 * @param name
	 * @return
	 */
	public static boolean isExist(POJO bean,String name) {
		Map<String,Object> params = new HashMap<>();
		params.put("name", name);
		POJO pojo = bean.get(params);
		return pojo==null? false :true;
	}
	/**
	 * 通过名称查询是否存在
	 * @param bean
	 * @param name
	 * @return
	 */
	public static boolean isExist(POJO bean,Map<String,Object> params) {
		POJO pojo = bean.get(params);
		return pojo==null? false :true;
	}
}
