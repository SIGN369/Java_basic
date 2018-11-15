package com.tree.util;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;



public class JsoupUtil 
{
	/**
	 * 把html过滤掉html，生成text
	 * @param html
	 * @return
	 */
	public static String Text(String html) {
		if(html==null) return "";
		return Jsoup.clean(html, new Whitelist());//过滤html,生存TEXT
		
	}
	
	public static String ImgCapture(Element element) {
		if(element==null) return null;
		Elements media = element.select("[src]");
		String element_string = element.html();
		 for (Element src : media) {          
				if (src.tagName().equals("img")){
					String  imgurl=src.attr("abs:src"); //取得编码
				    String  imgsrc=src.attr("src");
				    element_string=StringUtil.replace(element_string, imgsrc, imgurl);		       
				}
				     
		      }
		return element_string;
	}
	
	/**
	 * 取全部图片
	 * @return
	 */
	public static List<String> Images(String html) {
			
		List<String> list = new ArrayList<String>();
		//从词条中取得一张图片
				Document doc= Jsoup.parse(html);
				Elements imgs = doc.select("img");
				for(int i=0;i<imgs.size();i++){
					  Element img = imgs.get(i);
						String src = img.attr("abs:src");
						
						//File file = new File(request.getSession().getServletContext().getRealPath("../"));
						list.add(src);//	
				}
		return list;
		
	}
	/**
	 * 取得第一张图片
	 * @param html
	 * @return
	 */
	public static String Image(String html) {
		
		//从词条中取得一张图片
				Document doc= Jsoup.parse(html);
				Elements imgs = doc.select("img");
				for(int i=0;i<imgs.size();){
					  Element img = imgs.get(i);
						String src = img.attr("abs:src");
						
						//File file = new File(request.getSession().getServletContext().getRealPath("../"));
						return src;//
				}
				return null;
		
		
	}
	
	public static String RPImage(String html,String fsHost,String imgurl) {
		List<String> list = Images(html);
		for (String rimg : list) {
			String img = ImgUtil.saveImg(rimg, fsHost+"/uploadurl");
			if(img!=null)
				html=StringUtil.replace(html, rimg, imgurl+img);
		}
		return html;
		
	}
	
	public static String RImage(String html) {
		
		//从词条中取得一张图片
				Document doc= Jsoup.parse(html);
			
				//Whitelist whitelist = new Whitelist();
				//whitelist.addTags( "a" ,"href","b", "blockquote"," br"," code", "dd", "dl", "dt"," em"," i", "li", "ol","p"," pre"," q"," small"," strike", "strong", "sub", "sup"," u", "ul","br","div");
				/*
				 *  a, b, blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q, small, strike, strong, sub, sup, u, ul
				 */
				String summary=Jsoup.clean( doc.toString(), Whitelist.basic());
				
				return summary;
		
		
	}
	
	
	 public static String Basic(String html) {
		
		//从词条中取得一张图片
				Document doc= Jsoup.parse(html);
			
				Whitelist whitelist = new Whitelist();
				whitelist.addTags( "b", "blockquote"," br"," code", "dd", "dl", "dt"," em"," i", "li", "ol","p"," pre"," q"," small"," strike", "strong", "sub", "sup"," u", "ul","br","div");
				/*
				 *  a, b, blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q, small, strike, strong, sub, sup, u, ul
				 */
				String summary=Jsoup.clean( doc.toString(), whitelist);
				
				return summary;
		
		
	}
	
	
		public static String clean(String html) {
			
			if(html==null) return null;
			Whitelist whitelist = new Whitelist()
	        .addTags(
	                 "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em",
	                "i", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong", "sub",
	                "sup", "u", "ul")
	                .addTags("img")
	                .addAttributes("img", "align", "alt", "height", "src", "title", "width")
	                .addProtocols("img", "src", "http", "https") ;

			 html=Jsoup.clean( html,  whitelist);
			 
			return removeEmpty(html);
			
		}
		
		/**

		 * 清除数据

		 * @param dest

		 * @param e

		 * @return

		 * @throws Exception 

		 */
		public static Element remove(Element dest,Element e) throws Exception {
			String e_string = HtmlCompressor.compress(dest.toString());	
			String e_s = HtmlCompressor.compress(e.toString());

			e_string = StringUtil.remove(e_string, e_s);	
			Document doc = Jsoup.parse(e_string, dest.baseUri());;
			return doc.body().getElementsByTag(dest.tagName()).first();
			
		}
		
		public static String removeEmpty(String element_string)  {		
			try {
				element_string=HtmlCompressor.compress(element_string);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return StringUtil.remove(element_string, "<p></p>");
			
		}

	
		
	
}

