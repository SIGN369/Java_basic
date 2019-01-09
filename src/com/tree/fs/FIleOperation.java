package com.tree.fs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * IO stream
 * Operation of writing and reading files.
 * @author zyg
 *
 */
public class FIleOperation {
		/**
		 * Write file to disk.
		 * @throws MalformedURLException 
			*/
	public static  void basic() throws MalformedURLException {
		//1、Create a new file;
		File file = new File("fs.temp.path=G://pm-fs//temp");
		file.isDirectory();
		file.isFile();
		file.exists();
		file.canRead();
		file.setReadable(true);
		file.setReadOnly();
		file.getAbsolutePath();
		file.getPath();
		URI uri = file.toURI();
		file.toURL();
	}
	/**
	 * Read file from file system.
	 */
	public void readFile() {
		
	}
	public static void main(String[] args) throws MalformedURLException {
		basic();
	}
//	public static void main(String[] args) throws IOException {
//	URL url = new URL("https://fang-oss.haozu.com/hzfs56/HI/NV/X6/b77043a3d4d35ffc45460dfbe941bbbf.jpg");
//	File file = new File("F:\\Develop\\tools\\SSR\\b77043a3d4d35ffc45460dfbe941bbbf.jpg");
//		InputStream in = url.openStream();
//		OutputStream out = new FileOutputStream(file);
//		byte[] by = new byte[1000];
//	        int n = 0;
//	        while (-1 != (n = in.read(by))) {
//	        	out.write(by, 0, n);
//	        }
//	        in.close();
//	        out.close();
//	System.out.println(out.toString());
//}
}
