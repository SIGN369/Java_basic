package com.tree.annotation;
/**
 * 自定义注解
 * @author admin
 *
 */
public class HostManager {
	private String remoteAddr;
	private String protocol;
	
	/**
	 * 使用注解来进行权限控制，调用方法前检查权限
	 * @param userId
	 * @return
	 */
	@CanAccess(role="root")
	public String acceessSecret(String userId){
		return "调用成功！";
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
}
