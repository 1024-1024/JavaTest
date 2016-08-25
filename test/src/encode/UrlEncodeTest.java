package encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlEncodeTest {
	public static void main(String[] args) {
		
//		/**
//		 * 除了字母和数字和-.*_四个字符，其他会转译成%+16进制数
//		 */
//		String strin = "你好";
//		String a1 = "-.*_";
//		try {
//			System.out.println(URLEncoder.encode(strin,"utf-8"));
//			System.out.println("中文转译："+URLEncoder.encode(a1, "utf-8"));
//			System.out.println(URLEncoder.encode("-" ,"utf-8"));
//			System.out.println("空格encode后："+URLEncoder.encode(" ", "utf-8"));
//			System.out.println("+decode后：" +URLDecoder.decode("+", "utf-8"));
//			System.out.println(URLEncoder.encode("+", "utf-8"));
//			System.out.println("-------------------");
//			
//			
//			
//			
//			System.out.println(URLEncoder.encode(" -.*_","utf-8"));
//			System.out.println(URLDecoder.decode(" -.*_","utf-8"));
//			System.out.println("-------------------");
//			System.out.println(URLEncoder.encode("!","utf-8"));
//			System.out.println("!".hashCode());
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		
	}
	
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
