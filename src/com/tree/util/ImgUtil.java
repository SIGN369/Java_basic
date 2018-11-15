package com.tree.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;




import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 *  图片操作
 * @author tngou
 *
 */
public class ImgUtil {
	private static final Logger log= LoggerFactory.getLogger(ImgUtil .class);

	
	public static String saveImg(String url,String fshost) {
		try {
			Document doc = Jsoup.connect(fshost).data("url", url).ignoreContentType(true).post();
			if(doc!=null)
			{
				return doc.body().text();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getImg(String fshost ,String keyword,int width) {
		try {
			Document doc = Jsoup.connect(fshost).data("keyword", keyword).data("width", width+"").ignoreContentType(true).post();
			if(doc!=null)
			{
				return doc.body().text();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 下载图片
	 * @param imgUrl 图片地址
	 * @param savePath 保存地址
	 * @param saveUrl 保存的URL地址
	 * @return
	 */
	public static String DownImg(String imgUrl,String savePath ,String saveUrl,String name) {
	
		    //取得今天时间
			
//			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyMMdd");
//			LocalDate date =LocalDate.now();
//	        String ymd = date.format(f);
//			savePath += ymd + "/";
//			saveUrl += ymd + "/";	        
			File dirFile = new File(savePath); //如果今天的目录存储就创建
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			
		 try {
					
				URL ImgUrl= new URL(imgUrl);
				String ext = FilenameUtils.getExtension(imgUrl).toLowerCase();					
				    if(StringUtils.isEmpty(ext))ext="jpg";
//					String fileExt = imgurl.substring(imgurl.lastIndexOf(".") + 1).toLowerCase();
					if(StringUtils.isEmpty(name)) name=DigestMD.MD5(imgUrl);
					name = name +"."+ext ;				
					//取得今天时间			
					File fileDest = new File(savePath, name);
//					FileOutputStream fos = new FileOutputStream(fileDest);
					//FileUtils.copyFile(imgData, fos);
//					FileUtils.copyURLToFile(ImgUrl, fileDest);
//					boolean status = _downImg(ImgUrl, fileDest);
//					if(!status)   return null;

					if(! _copyURLToFile(ImgUrl, fileDest))
					{
						return null;
					}
						
					//IOUtils.copy(imgData, fos);	
					saveUrl  += name;
				

		   return saveUrl;
	   } catch (Exception e) {
		   log.error("现在图片地址-{}-出错",imgUrl);
		   return null;
		}
		
		
		
	}
	
	
	
	private static boolean _downImg(URL ImgUrl,File fileDest) {
		boolean status = false;  
		
		ExecutorService executor = Executors.newSingleThreadExecutor();  
		 Callable<String> call = new Callable<String>() {  
		        public String call() throws Exception {  
		        	_copyURLToFile(ImgUrl, fileDest);
		        	
		            return "true";  
		        }  
		    }; 
		   
			try {
				Future<String> future = executor.submit(call);  
				String obj = future.get(1000 * 10, TimeUnit.MILLISECONDS);  //设置10s过期时间
				status = Boolean.parseBoolean(obj);
			} catch (InterruptedException | ExecutionException
					| TimeoutException e) {
		
				e.printStackTrace();
				status = false; 
			}
			
			
			executor.shutdown(); 
		return status;
	}
	
	
	
	private static boolean _copyURLToFile( URL imgUrl, File fileDest )
	{
		
		String imgurl = imgUrl.toString();
		try {
		HttpURLConnection cnx = (HttpURLConnection)imgUrl.openConnection();
		cnx.setAllowUserInteraction(false);         
		cnx.setDoOutput(true);
		cnx.addRequestProperty("Cache-Control", "no-cache");
		cnx.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0");
		cnx.addRequestProperty("Referer", imgurl.substring(0, imgurl.indexOf('/', imgurl.indexOf('.'))+1));
		
			cnx.connect();
		
		if(cnx.getResponseCode() == HttpURLConnection.HTTP_OK)
		{
			InputStream imgData = cnx.getInputStream();
		
			FileOutputStream fos = new FileOutputStream(fileDest);

			IOUtils.copy(imgData, fos);
			
			IOUtils.closeQuietly(imgData);
			IOUtils.closeQuietly(fos);	

		}else
		{
			return false;
		}
		
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	
}

