package com.tree.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.mozilla.universalchardet.UniversalDetector;

/**   
 * Filename:    CharsetDetector.java   
 * Copyright:   Copyright (c)2014 
 * Company:     rimi  
 * @version:    1.0   
 * @since:      JDK 1.7.0_21  
 * Create at:   2014年9月10日 上午10:44:33   
 * Description:  取得编码
 *   
 * Modification History:   
 * Date             Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2014年9月10日           陈磊                  1.0         1.0 Version   
 */

public class CharsetDetector {

	
	/**
	 * 
	* <p>Title: guessEncoding<／p>
	* <p>Description: 取得二进制的编码 <／p>
	* @param bytes
	* @return  编码格式  默认返回的是UTF-8
	 */
	public static String GuessEncoding(byte[] bytes) {
	    String DEFAULT_ENCODING = "UTF-8";
	    UniversalDetector detector =
	            new UniversalDetector(null);
	    detector.handleData(bytes, 0, bytes.length);
	    detector.dataEnd();
	    String encoding = detector.getDetectedCharset();
	    detector.reset();
	    if (encoding == null) {
	        encoding = DEFAULT_ENCODING;
	    }
	    return encoding;
	}
	
	
//	public static String GuessEncoding(InputStream file) throws IOException {
//		 ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream();
//	        int   i=-1;
//	        while((i=file.read())!=-1){
//	        baos.write(i);
//	        }
//	    
//	        return CharsetDetector.GuessEncoding( baos.toString().getBytes()); 
//		  
//	}
	
	public static String ChangeCode(String input) {
		
		
		String output=input;
		try {
			output = new String(input.getBytes(GuessEncoding(input.getBytes())), "UTF-8");//主要是处理get方式编码问题
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		return output;
		
	}
	
	
}

