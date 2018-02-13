package com.tree.job.written.Y2017;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**���ģ����еķ��Ŷ�������-�˽��� ���ӳ�䣬ת���ľ�ok��byte<char<int
 * �ַ��������ȫ
 * 1���ַ����ı�������ȡÿһ���ַ���
 * 2���ַ���ת��Ϊ�ֽ����飬�ú��������ַ����Ĺ��췽���ع��ַ�����Ӧ����IO��
 * 3���ַ���ת��Ϊ�ַ����飬str.toCharArray();����ͳ��ÿһ���ַ�������
 * 4���ж��ַ����Ƿ�������ֻ����ǲ����ַ�������
 * 5���ж��Ƿ�Ϊ��
 * 6���ı��ַ����ı���
 * @author zyg
 *
 */
public class StringUtils {
	/**
	 * 1���ַ����ı�������ȡÿһ���ַ���
	 * @param str
	 */
   public static void traversal(String str) {
	   char[] charArray = str.toCharArray();
	   for (char c : charArray) {
		System.out.println(c);
	}
   }
   /**
    * ͳ���ַ���
    */
   public static String stastistic(String string) {
	   char[] charArray = string.toCharArray();
	   int blank = 0;
	   int letter = 0;
	   int numeric = 0;
	   int others = 0;
	   for(int i=0;i<charArray.length;i++) {
		   char key = charArray[i];
		   if((key>'a'&&key<'z')||(key<'Z'&&key>'A')) {
			   letter++;
		   }else if(key==' ') {
			   blank++;
		   }else if(key>0&&key<9) {
			   numeric++;
		   }else {
			others++;
		}
	   }
	return "��ĸ��"+letter+"��"+"���֣�"+numeric+"��"+"�ո�"+blank+"��"+"������"+others+"��";
   }
   /**
    * �ַ������뷽ʽ��ת��
    */
   public static String changeCharset(String strs) {
	   try {
		return new String(strs.getBytes(), "utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	return null;
   }
// �ж�һ���ַ����Ƿ�Ϊ����    
public boolean isDigits(String strNum) {    
    return strNum.matches("[0-9]{1,}");    
}    
    
// �ж�һ���ַ����Ƿ�Ϊ����    
public boolean isDigit(String strNum) {    
    Pattern pattern = Pattern.compile("[0-9]{1,}");    
    Matcher matcher = pattern.matcher((CharSequence) strNum);    
    return matcher.matches();    
}  
  
//��ȡ����    
public String getNumbers(String content) {    
    Pattern pattern = Pattern.compile("\\d+");    
    Matcher matcher = pattern.matcher(content);    
    while (matcher.find()) {    
       return matcher.group(0);    
    }    
    return "";    
}    
    
// ��ȡ������    
public String splitNotNumber(String content) {    
    Pattern pattern = Pattern.compile("\\D+");    
    Matcher matcher = pattern.matcher(content);    
    while (matcher.find()) {    
        return matcher.group(0);    
    }    
    return "";    
}  
    
// �ж�һ���ַ����Ƿ�������  
public boolean HasDigit(String content) {  
    boolean flag = false;  
    Pattern p = Pattern.compile(".*\\d+.*");  
    Matcher m = p.matcher(content);  
    if (m.matches()) {  
        flag = true;  
    }  
    return flag;  
}  
public static boolean isNumeric(String str) {  
    Pattern pattern = Pattern.compile("[0-9]*");  
    return pattern.matcher(str).matches();  
}  
}
