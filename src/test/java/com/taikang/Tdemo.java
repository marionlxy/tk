package com.taikang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

public class Tdemo {
		public static void main(String[] args) {
/*			System.out.println(System.getenv("PATH")+"\n"+System.getenv("JAVA_HOME"));
			System.getProperty("pencil color");  // 得到属性值
			//java -Dpencil color=green
			System.getProperty("java.specification.version");  // 得到Java版本号
			Properties p = System.getProperties();  // 得到所有属性值
			p.list(System.out);*/
			
/*			//3.String Tokenizer
			// 能够同时识别, 和 |
			StringTokenizer st = new StringTokenizer("Hello, Wor.ld|of|Java", ", | .");
			while (st.hasMoreElements()) {
			    st.nextToken();
			    System.out.print(st.nextToken());
			}
			// 把分隔符视为token
			//StringTokenizer st = new StringTokenizer("Hello, World|of|Java", ", |",  true);
			//4. StringBuffer(同步)和StringBuilder(非同步)
			StringBuilder sb = new StringBuilder();
			sb.append("Hello");
			sb.append("World");
			sb.toString();
				 // 反转字符串
			System.out.println(new StringBuffer(sb).reverse());
		*/
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String str3 = "1927-12-31 23:54:08";  
	    String str4 = "1927-12-31 23:54:09";  
	    Date sDt3 = null;
		try {
			sDt3 = sf.parse(str3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    Date sDt4 = null;
		try {
			sDt4 = sf.parse(str4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    long ld3 = sDt3.getTime() /1000;  
	    long ld4 = sDt4.getTime() /1000;
	    System.out.println(ld4-ld3);
	    
		}	    
}
