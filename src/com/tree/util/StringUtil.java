package com.tree.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;




public class StringUtil extends org.apache.commons.lang3.StringUtils  {

	
	/**
	 * 
	* @Description: 替换空格 ，半角 、全角
	 */
	 public static String ReplaceBlank(String str) {
		    if (str==null)return str;
	         Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	         Matcher m = p.matcher(str);
	         str = m.replaceAll("");  
		    str= remove(str, "　");
	        str=remove(str, " ");	
	        return str;
	 }
	
	 
	 public  static String  RemoveEmpty(String str) {
		    if (str==null)return str;
		    str=str.replaceAll("\\u00A0", "");
		    str=str.replaceAll("\\n", "");
		    str=str.replaceAll("\\r", "");		    
		    str=removeStart(str, " ");
		    str=removeEnd(str, " ");
		    return str;
	 }
	 
	 public  static String  cleanKey(String str) {
		    if (str==null)return str;
		    str=RemoveEmpty(str);
		    str=str.replaceAll("：", "").replaceAll(":", "").replaceAll("【", "").replaceAll("】", "").replaceAll(" ", "").replaceAll("　", "");
		    return RemoveEmpty(str);
	 }
	
	
	 
}

