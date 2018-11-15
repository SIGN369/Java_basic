package com.tree.po;
/**
 * 建立实体的规约：
 * 1、所有的基本数据类型必须使用封装类，杜绝默认值风险
 * 2、是否字段必须要用下划线分开-否则远程调用有序列化问题：is_open[正确]——isopen[错误]
 * 3、适度增加冗余字段--提高查询效率
 * 4、注意继承--代码复用
 * @author zyg
 *
 */
public class TestPo extends BasePO{
	
	private String name = "xgx";
	private Integer longitude;//经度
	private Integer latitude;//纬度
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	
	
	
}
