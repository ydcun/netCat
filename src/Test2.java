import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpHost;



public class Test2 {
	private StringBuffer sb =null;
	public String p(){
		URL url=null;
		try {
			url = new URL("http://www.csdn.net/");
			 URLConnection conn = url.openConnection();//打开网页链接   
             InputStreamReader isr = new InputStreamReader(conn  
                    .getInputStream(), "utf-8");  
            BufferedReader br = new BufferedReader(isr);  
             String line = null;  
            sb = new StringBuffer();  
            while ((line = br.readLine()) != null) {  
               sb.append(line);  
            }
            
		} catch (Exception e) {
			System.out.println("获取链接错失败");
			e.printStackTrace();
		}
		return sb.toString();
                   
	}
	public static void main(String[] args) {
		System.out.println(new Test2().p());
	}
}
