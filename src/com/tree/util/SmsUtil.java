package com.tree.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.bgs360.controller.BaseController;

/**
 * 短信
 * @author tngou@tngou.net
 *
 */
@Component
public class SmsUtil {
	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	//产品名称:云通信短信API产品
    static final String product = "Dysmsapi";
    //产品域名
    static final String domain = "dysmsapi.aliyuncs.com";
    @Value("${sm.accessKeyId}")
    private String accessKeyId;
    @Value("${sm.accessKeySecret}")
    private  String accessKeySecret;
    @Value("${sm.signName}")
    private String signName;
    
    
//    #您的验证码${code}，该验证码5分钟内有效，请勿泄漏于他人！
    @Value("${sm.templateCode}")
    private String templateCode;
//    #你好${name},您有新的任务需求，请注意查收！
    @Value("${sm.templateNoticeCode}")
    private String templateNoticeCode;
//    #平台为你创建新的用户账号角色${role}，您的账号：${account}，密码:${password} ；
    @Value("${sm.templateNewUserCode}")
    private String templateNewUserCode;
//   你好，你的预约已经申请成功，我们会尽快安排客户通过电话联系你！请你保持电话畅通和接听我们客户电话。谢谢
    @Value("${sm.templateNotice}")
    private String templateNotice;
//  
    @Value("${sm.templateNewDemand}")
    private String templateNewDemand;
   
    
    
    /**
     * 发送给客服 
     * @param tel
     * @param account
     * 有新的预约看房提醒，用户${account}，请登录平台尽快联系客户！
     * @return
     */
    public boolean sendNotice(String tel) {
    	JSONObject json = new JSONObject();
    
		SendSmsResponse r;
		try {
			r = sendSms(tel, templateNotice, json.toJSONString());
			if("OK".equals(r.getCode()))
				return true;
			
		} catch (UnsupportedEncodingException | ClientException e) {
			e.printStackTrace();
		}
		return false;
    }
    /**
     * 发送给客服 
     * @param tel
     * @param account
     * 有新的预约看房提醒，用户${account}，请登录平台尽快联系客户！
     * @return
     */
    public boolean sendNewDemand(String tel,String account) {
    	JSONObject json = new JSONObject();
    	json.put("account", account);
		SendSmsResponse r;
		try {
			r = sendSms(tel, templateNewDemand, json.toJSONString());
			if("OK".equals(r.getCode()))
				return true;
			
		} catch (UnsupportedEncodingException | ClientException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    /**
     * 发生一般验证码
     * tel : 电话号码
     * code : 编码
     * 您的验证码${code}，该验证码5分钟内有效，请勿泄漏于他人！
     * @return 
     */
    public boolean sendCode(String tel,String code) {
    	JSONObject json = new JSONObject();
    	json.put("code", code);
		SendSmsResponse r;
		try {
			r = sendSms(tel, templateCode, json.toJSONString());
			if("OK".equals(r.getCode()))
				return true;
			
		} catch (UnsupportedEncodingException | ClientException e) {
			e.printStackTrace();
		}
		return false;
		
	}
    
    /**
     * 发送通知
     * @param tel  电话
     * @param name 姓名
     * 你好${name},您有新的任务需求，请注意查收！
     * @return
     */
    public boolean sendNotice(String tel,String name) {
    	JSONObject json = new JSONObject();
    	json.put("name", name);
		SendSmsResponse r;
		try {
			r = sendSms(tel, templateNoticeCode, json.toJSONString());
			if("OK".equals(r.getCode()))
				return true;
			
		} catch (UnsupportedEncodingException | ClientException e) {
			e.printStackTrace();
		}
		return false;
	}
    
    /**
     * 
     * @param tel
     * @param role
     * @param account
     * @param password
     *  #平台为你创建新的用户账号角色${role}，您的账号：${account}，密码:${password} ；
     * @return
     */
    public boolean sendNewUser(String tel,String role,String account,String password) {
    	JSONObject json = new JSONObject();
    	json.put("role", role);
    	json.put("account", account);
    	json.put("password", password);
		SendSmsResponse r;
		try {
			r = sendSms(tel, templateNewUserCode, json.toJSONString());
			if("OK".equals(r.getCode()))
				return true;
			
		} catch (UnsupportedEncodingException | ClientException e) {
			e.printStackTrace();
		}
		return false;
	}
    
    

    /**
     * 
     * @param tel  电话
     * @param templateCode  模板ID
     * @param paramJson  参数
     *   模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
     *   {"name":"Tom", "code":"123"}
     * @return
     * @throws ClientException
     * @throws UnsupportedEncodingException 
     */
    public SendSmsResponse sendSms(String tel,String templateCode,String paramJson) throws ClientException, UnsupportedEncodingException {
    	//可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(tel);
        //必填:短信签名
        request.setSignName(new String(signName.getBytes("iso-8859-1"),"utf-8"));
        //必填:短信模板
        request.setTemplateCode(templateCode);
        if(StringUtils.isNoneEmpty(paramJson))
        	request.setTemplateParam(paramJson);
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse response = acsClient.getAcsResponse(request);
        
        log.info("发生短信手机号：{};返回状态{}-{}", tel,response.getCode(),response.getMessage());
        return response;
		
	}
    
}
