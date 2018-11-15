package com.tree.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bgs360.pojo.Building;
import com.bgs360.pojo.Company;
import com.bgs360.pojo.Domain;
import com.bgs360.pojo.Trade_area;

@Component
public class JSONReadUtil {
	@Autowired
	private SpringBeansUtil beans;

	public void JSONRead(String string) throws IOException {
		String str = FileUtils.readFileToString(new File(string));
		JSONObject json = JSON.parseObject(str);
		JSONArray arr = json.getJSONArray("RECORDS");
		System.out.println(json);
		System.out.println(arr);
		Domain bean = beans.getBean(Domain.class);
		Trade_area trade_area = beans.getBean(Trade_area.class);
		Building building = beans.getBean(Building.class);
		for (Object object : arr) {

			JSONObject j = (JSONObject) object;
			building.setName(j.getString("name")); // 楼宇名称
			building.setArea_name(j.getString("trading_area"));// 商圈名称
			building.setLng(Double.valueOf(Lng(j.getString("latlng"))));// 经度
			building.setLat(Double.valueOf(Lat(j.getString("latlng"))));// 维度
			if (NumberUtils.isCreatable(Acreage(j.getString("rented_area"))))
				building.setAcreage(Double.parseDouble(Acreage(j.getString("rented_area"))));// 可租面积
			if (NumberUtils.isCreatable(Max_Acreage(j.getString("rented_area"))))
				building.setMax_acreage(Double.parseDouble(Max_Acreage(j.getString("rented_area"))));// 可租面积
			// System.out.println("原始数据"+j.getString("built_area"));
			//building.setBuilding_area(Mianji(Judgment(j.getString("built_area"))));// 建筑面积
			building.setStandard_height(
					Double.valueOf(Standard_height(Judgment(j.getString("standard_height")) * 10)));// 层高(M)
			building.setTotal_floor(Integer.valueOf(Judgment(j.getString("total_floor"))));// 总层数
			building.setRenting_source(Judgment(j.getString("renting_source")));// 可租房源
			// System.out.println(j.getString("district_name"));
			building.setDoamin(Long.valueOf(bean.get("name like '%" + j.getString("district_name") + "%'").getId()));// 区域
			Object area = trade_area.get("name like '%" + j.getString("trading_area") + "%'");
			if (area == null) {
				building.setArea(Long.valueOf(188));// 商圈
			} else
				building.setArea(
						Long.valueOf(trade_area.get("name like '%" + j.getString("trading_area") + "%'").getId()));// 商圈
			building.setPrice(Double.valueOf(Judgment(Price(j.getString("price")))));// 价格
			building.setMax_price(Double.valueOf(Judgment(Max_Price(j.getString("price")))));// 最高价格
			building.setImgs(j.getString("imgs"));// 图片
			building.setAddress(j.getString("latlng"));// 地址
			building.setTraffic(j.getString("traffic"));// 地铁交通情况
			building.setAddress(j.getString("address"));// 地址
			building.setDes(j.getString("des"));// 描述
			building.setDevelopers(j.getString("developers"));// 开发商
			building.setProperty(j.getString("property"));// 物业公司
			building.setDoamin_name(j.getString("region"));// 地区
			building.setCity_name(j.getString("city_name"));// 城市名称
			building.setCity(bean.get("name = '成都市'").getId());// 城市(固定)
			System.out.println(building);
			building.save();
		}
		

	}

	// 最高价格
	private static String Max_Price(String str) {
		String[] arr = new String[5];
		if (str.length() == 0) {
			return "0";
		}
		if (str.indexOf("-") != -1) {
			String[] strArray = str.split("-");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			return arr[1];
		} else {
			return "0";
		}
	}

	// 默认最低价格
	private static String Price(String str) {
		String[] arr = new String[5];
		if (str.length() == 0) {
			return "0";
		}
		if (str.indexOf("-") != -1) {
			String[] strArray = str.split("-");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			return arr[0];
		} else {
			return str;
		}
	}

	private static int Judgment(String string) {
		String str = DigitsUtil.get_StringNum(string);
		if (str == null || str.isEmpty() || str == "") {
			return 0;
		} else {
			return Integer.valueOf(str);
		}
	}

	// 取经度
	private String Lng(String string) {
		String[] arr = new String[2];
		if (string.indexOf(",") != -1) {
			String[] strArray = string.split(",");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			return arr[0];
		} else {
			return "0.000000000000000";
		}
	}

	// 维度
	private String Lat(String str) {
		String[] arr = new String[5];
		if (str.indexOf(",") != -1) {
			String[] strArray = str.split(",");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			return arr[1];
		} else {
			return "0.000000000000000";
		}
	}

	// 可租最低面积
	private String Acreage(String str) {
		String[] arr = new String[2];
		if (str == null || str.isEmpty() || str == "") {
			return "0";
		} else if (str.indexOf("-") != -1) {
			String[] strArray = str.split("-");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			// System.out.println("最低面积："+arr[0]);
			return arr[0];
		} else {
			return Remove(str);
		}
	}

	// 最大面积
	private String Max_Acreage(String str) {
		String[] arr = new String[2];
		if (str == null || str.isEmpty() || str == "") {
			return "0";
		} else if (str.indexOf("-") != -1) {
			String[] strArray = str.split("-");// 分割出来的字符数组
			for (int i = 0; i < strArray.length; i++) {
				arr[i] = strArray[i];
			}
			// System.out.println("最大面积"+Remove(arr[1]));
			return Remove(arr[1]);
		} else {
			return "0";
		}
	}

	// 层高判断
	private double Standard_height(double i) {
		if (i > 500) {
			return 0;
		}
		return i;
	}

	// 去单位
	public String Remove(String str) {
		String newStr = str.substring(0, str.length() - 2);
		// System.out.println(newStr);
		return newStr;
	}
	// 去后7位
	public String Remove7(String str) {
		String newStr = str.substring(0, str.length() - 7);
		// System.out.println(newStr);
		return newStr;
	}

	// 去掉最后一位
	public static String Remove1(String str) {
		String newStr = str.substring(0, str.length() - 1);
		// System.out.println(newStr);
		return newStr;
	}
	// 去掉最后3位
	public static String Remove3(String str) {
		String newStr = str.substring(0, str.length() - 3);
		// System.out.println(newStr);
		return newStr;
	}
	
	//时间格式化
	public static String Format() {
		 SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
		 String  time = format0.format("2015年12月32日");
		 return time;
	}

	// panduan
	private int Mianji(int str) {
		if (str > 8388607) {
			return 0;
		}
		return str;
	}

	/**
	 * 1
	 * 
	 * @param string
	 * @throws IOException
	 */
	public void JSONRead2(String string) throws IOException {
		String str = FileUtils.readFileToString(new File(string));
		JSONObject json = JSON.parseObject(str);
		JSONArray arr = json.getJSONArray("RECORDS");
		Domain bean = beans.getBean(Domain.class);
		Building building = beans.getBean(Building.class);
		// Map<String, ?> map = null;
		Map<String, String> map = new HashMap<String, String>();
		for (Object object : arr) {
			
			JSONObject j = (JSONObject) object;
			
			Building build = building.get("name like '%" + j.getString("name") + "%'");
			
			//System.out.println(j.getString("name"));
			//System.out.println(build);
			if (build != null) {
				String njson = j.getString("json");
				JSONObject newjson = JSON.parseObject(njson);
				//System.out.println(newjson);
				/**
				 * 办公
				 */
				JSONObject properties = newjson.getJSONObject("办公");// 找到properties的json对象
				JSONObject properties1 = newjson.getJSONObject("商业");// 找到properties的json对象
				JSONObject properties2 = newjson.getJSONObject("基本信息");// 找到properties的json对象
				if (properties != null) {
					// 总户数
					String households = properties.getString("总户数");
					if (!households.equals("暂无数据")) {
						map.put("households", Remove1(households));
					}
					// 办公面积
					String work_area = properties.getString("办公建筑面积");
					if (!work_area.equals("暂无数据")) {
						map.put("work_area", Remove(work_area));
					}
					// 资质等级
					String property_grade = properties.getString("物业级别");
					if (!property_grade.equals("暂无数据")) {
						map.put("property_grade", property_grade);
					}
					// 客梯数
					String passenger_ladder = properties.getString("客梯数");
					if (!passenger_ladder.equals("暂无数据")) {
						map.put("passenger_ladder", Remove1(passenger_ladder));
					}
					
					//货梯数
					String cargo_ladder = properties.getString("货梯数");
					if(!cargo_ladder.equals("暂无数据")) {
						map.put("cargo_ladder", Remove1(cargo_ladder));
					}
					//ladder电梯总量
					if(!passenger_ladder.equals("暂无数据")&&!cargo_ladder.equals("暂无数据")) {
						Integer ladder = Integer.valueOf(Remove1(passenger_ladder))+Integer.valueOf(Remove1(cargo_ladder));
						map.put("ladder", String.valueOf(ladder));
					}
					// 物业公司
					String property = properties.getString("物业公司");
					if (!property.equals("暂无数据")) {
						map.put("property", property);
					}
					// 开工建设时间
					String build_year = properties.getString("开盘时间");
					if (!build_year.equals("暂无数据")) {
						map.put("build_year", build_year);
						
					} 
					// 出租房间面积大小
					String acreage = properties.getString("户型区间");
					if (!acreage.equals("暂无数据")) {
						if(acreage.indexOf("-")!=-1) {
							map.put("acreage", Acreage(acreage));
							map.put("max_acreage", Max_Acreage(acreage));
						}else{
							map.put("acreage", Remove(acreage));
						}
						
					} 
					
					//土地使用年限
					String property_year = properties.getString("土地使用年限");
					if(!property_year.equals("暂无数据")) {
						map.put("property_year", Remove1(property_year));
					}
					
					

					//装修情况renovation
					String renovation =properties.getString("装修情况");
					
					if(!renovation.equals("暂无数据")||!renovation.equals("其他")) {
						if(renovation.equals("毛坯")||renovation.equals("其它,毛坯")) {
							map.put("renovation", "00001");
						}else if(renovation.equals("普通装修")||renovation.equals("普通装修,毛坯")) {
							map.put("renovation", "00010");
						}else if(renovation.equals("精装修")||renovation.equals("毛坯,精装修")||renovation.equals("精装修,毛坯")) {
							map.put("renovation", "00100");
						}else if(renovation.equals("豪华装修")||renovation.equals("毛坯,豪华装修")||renovation.equals("豪华装修,其它")) {
							map.put("renovation", "10000");
						}

						//物业费
					String office_fee= properties.getString("物业费");
					if(!office_fee.equals("暂无数据")) {
						map.put("office_fee", Remove7(office_fee));
					}
					
					
				}

				
				}
				/**
				 * 商业
				 */

				if (properties1 != null) {
					//交房时间
				String completed_year1=	properties1.getString("交房时间");
				if(!completed_year1.equals("暂无数据")) {
					map.put("completed_year", completed_year1);
				}
				else {
					String acreage1 = properties1.getString("户型区间");
					if(acreage1!=null) {
					if (!acreage1.equals("暂无数据")) {
						map.put("acreage", Acreage(Remove(acreage1)));
						
					}
					}
				}
				
				
				}
					
				/**
				 * 基本信息
				 */

				if (properties2 != null) {
					// 容积率
					String oldvolumetric_rate = properties2.getString("容积率");
					if (!oldvolumetric_rate.equals("暂无数据")) {
						map.put("volumetric_rate", oldvolumetric_rate);
					}
					// 车位信息
					String parking = properties2.getString("车位信息");
					if (!parking.equals("暂无数据")) {
						map.put("on_parking", Remove1(parking));
					}
					// 绿化率
					String green_rate = properties2.getString("绿化率");
					if (!green_rate.equals("暂无数据")) {
						map.put("green_rate", Remove1(green_rate));
						//System.out.println(Remove1(green_rate));
					}
					// 建筑面积
					String building_area = properties2.getString("建筑面积");
					if (!building_area.equals("暂无数据")) {
						map.put("building_area", Remove(building_area));
					}

					// 开发商
					String developers = properties2.getString("开发商");
					if (!developers.equals("暂无数据")) {
						map.put("developers", developers);
					}
					//楼盘介绍
					String des = properties2.getString("楼盘介绍");
					if(!des.equals("暂无数据")) {
						map.put("des", des);
					}

					// 占地面积
					String land_area = properties2.getString("占地面积");
					if (!land_area.equals("暂无数据")) {
						map.put("land_area", Remove(land_area));
					}
					
					
					
				}
				
				System.out.println(map);
				System.out.println(build.getId());
				//building.update(map, build.getId());
			}
			

			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void JSONRead3(String string) throws IOException {
		String str = FileUtils.readFileToString(new File(string));
		JSONObject json = JSON.parseObject(str);
		JSONArray arr = json.getJSONArray("RECORDS");
		Domain bean = beans.getBean(Domain.class);
		Building building = beans.getBean(Building.class);
		
		for (Object object : arr) {
			Map<String, String> map = new HashMap<String, String>();
			JSONObject j = (JSONObject) object;
			Building build = building.get("name like '%" + j.getString("name") + "%'");
			if (build != null) {
				String njson = j.getString("json");
				JSONObject newjson = JSON.parseObject(njson);
//				System.out.println(newjson);
				JSONObject properties = newjson.getJSONObject("规划信息");// 找到properties的json对象
				JSONObject properties1 = newjson.getJSONObject("销售信息");// 找到properties的json对象
				JSONObject properties2 = newjson.getJSONObject("基本信息");// 找到properties的json对象	
//					System.out.println(properties.getString("占地面积"));
//					System.out.println("交房时间"+properties1.getString("交房时间"));
					// 总户数
					String jsonHouseholds = properties.getString("总户数");
					Integer	 buildHouseholds = build.getHouseholds();
					if(!jsonHouseholds.equals("暂无数据")&&buildHouseholds==0&&!jsonHouseholds.equals("")) {
							map.put("households", Remove1(jsonHouseholds));
					}
					// 建筑面积
					String jsonbuilding_area = properties.getString("建筑面积");
					Double buildbuilding_area = build.getBuilding_area();
					if(!jsonbuilding_area.equals("暂无数据")&&buildbuilding_area==0.0) {
							map.put("building_area", Remove3(jsonbuilding_area));
					}
					
					// 容积率
					String jsonvolumetric_rate = properties.getString("容积率");
					Double	 buildvolumetric_rate = build.getVolumetric_rate();
					if(!jsonvolumetric_rate.equals("暂无数据")&&buildvolumetric_rate==0.0) {
						
							map.put("volumetric_rate", jsonvolumetric_rate);
					}
					
					// 绿化率
					String jsongreen_rate = properties.getString("绿化率");
					Double	 buildgreen_rate = build.getGreen_rate();
					if(!jsongreen_rate.equals("暂无数据")&&buildgreen_rate==0.0) {
							map.put("green_rate", Remove1(jsongreen_rate));
					}
					
					// 停车位
					String jsonon_parking = properties.getString("停车位");
					Integer buildon_parking = build.getOn_parking();
					if(!jsonon_parking.equals("暂无数据")&&!jsonon_parking.equals("暂无资料")&&buildon_parking==0) {
						//System.out.println(jsonon_parking);
						String jsonon_parking2 =  DigitsUtil.get_StringNum(jsonon_parking);
						if(!jsonon_parking2.equals("")&&Integer.valueOf(jsonon_parking2)<10000) {
//							System.out.println(jsonon_parking2);
							map.put("on_parking", jsonon_parking2);
						}
						map.put("on_parking", DigitsUtil.get_StringNum(jsonon_parking));
					}
					
					// 占地面积
					String jsonland_area = properties.getString("占地面积");
					Double buildland_area = build.getLand_area();
					if(!jsonland_area.equals("暂无数据")&&buildland_area==0) {
						map.put("land_area", Remove3(jsonland_area));
					}
					
					//开工时间
					String jsonbuild_year =properties1.getString("开盘时间");
					Date buildbuild_year = build.getBuild_year();
					if(!jsonbuild_year.equals("待定")&&buildbuild_year==null) {
						if(jsonbuild_year.matches("\\d{4}-\\d{2}-")) {
							String jsonbuild_yea1 =Remove1(jsonbuild_year)+"-01";
//							System.out.println("开盘时间"+jsonbuild_yea1);
							map.put("build_year", jsonbuild_yea1);
					}else {
							map.put("build_year", Remove1(jsonbuild_year));
					}
						}
					
					
					//交房时间
					String jsoncompleted_year =properties1.getString("交房时间");
					Date buildcompleted_year = build.getCompleted_year();
					if(!jsoncompleted_year.equals("待定")&&buildcompleted_year==null) {
						
						if(jsoncompleted_year.matches("\\d{4}-\\d{2}-")) {
							String jsoncompleted_year2 =Remove1(jsoncompleted_year)+"-01";
//							System.out.println("交房时间："+jsoncompleted_year2);
							map.put("build_year", jsoncompleted_year2);
					}else {
						map.put("completed_year", Remove1(jsoncompleted_year));
					}
					}
					
					
					System.out.println(build.getId());
					System.out.println(map);
					building.update(map, build.getId());
					}
			

			
				}
				
					
				
			}
	
		
		
	}


