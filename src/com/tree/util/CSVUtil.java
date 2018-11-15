package com.tree.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

public class CSVUtil {
      //CSV文件分隔符
	  private static final String NEW_LINE_SEPARATOR = "\n";
	
	  
	  /**
	   * 读取文件返回List Map对象
	   * @param file  文件
	   * @param heades 需要获取的数据[]
	   * @return
	   */
	  public static List<Map<String,String>> readFile(InputStream file,String[] heades) {
		  List<Map<String,String>> list = new ArrayList<Map<String,String>>();   
		  try {		
			  ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream();
		        int   j=-1;
		        while((j=file.read())!=-1){ baos.write(j); }
		        InputStream   in_nocode   =   new   ByteArrayInputStream(baos.toByteArray());        
		        BufferedReader bufferdReader=new BufferedReader(new InputStreamReader(in_nocode,CharsetDetector.GuessEncoding(baos.toByteArray())));						
				@SuppressWarnings("resource")
				CSVParser csvFileParser = new CSVParser(bufferdReader,
				         CSVFormat.DEFAULT.withHeader(heades));
				 List<CSVRecord> csvRecords = csvFileParser.getRecords();	 
				 for (int i = 1; i < csvRecords.size(); i++) {
		             CSVRecord record = csvRecords.get(i);
					 list.add(record.toMap()); 
				 }
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			return list;
	}
	 
	  /**
	   * 写入到字符串
	   * @param list 数组
	   * @param heades 头文件
	   * @return
	   */
	 public static StringBuilder writeString(List<Map<String,String>> list,String[] heades) {
		 StringBuilder stringBuilder = new StringBuilder();
	        CSVPrinter csvFilePrinter = null;
	        //创建 CSVFormat
	        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
	        try {
	            //初始化FileWriter
	           
	            //初始化 CSVPrinter
	            csvFilePrinter = new CSVPrinter(stringBuilder, csvFileFormat);
	            //创建CSV文件头	  
//	            csvFilePrinter.printRecord(list.get(0).keySet());
	            csvFilePrinter.printRecord(heades);
	
	            // 遍历List写入CSV--与头部一一对应
	            for (Map<String, String> map : list) {
	            	String[] arr = new String[heades.length];
	            	for(int i=0;i<heades.length;i++) {
	            		arr[i] = map.get(heades[i]);
	            	}
	            	csvFilePrinter.printRecord(arr);
	            }
	           
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {	          
	                csvFilePrinter.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
			return stringBuilder;
	} 
}

