	import java.io.File;  
	import java.io.IOException;  
	  
	import org.jsoup.Jsoup;  
	import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  
	  
	/**
	 * @author ydcun
	 *http://www.open-open.com/jsoup   jsoup.jar的帮助文档
	 */
	public class dfgfd {  
	    public static void main(String[] args) {  
	        dfgfd t = new dfgfd();  
//	        t.parseFile();
//	        t.parseUrl();
	        t.parseString();
	    }  
	  
	    public void parseString() {  
	        String html = "<html><head><title>blog</title></head><body onload='test()'><p>Parsed HTML into a doc.</p><ydcun>111</ydcun></body></html>";  
	        Document doc = Jsoup.parse(html); //将字符串转换成文档 
	        System.out.println(doc);  //将文档输入（有缩进格式）
	        Elements es = doc.body().getAllElements();  //获取body节点的所有内容
	        System.out.println(es.attr("onload"));  
	        System.out.println(es.select("p"));  
	    }  
	  //获取百度中首页中的所有a标签中有href属性的节点
	    public void parseUrl() {  
	        try {  
	            Document doc = Jsoup.connect("http://www.baidu.com/").get();  
	            Elements hrefs = doc.select("a[href]");  
	            System.out.println(hrefs);  
	            System.out.println("------------------");  
	            System.out.println(hrefs.select("[href^=http]"));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  //从input.html中获取数据源
	    public void parseFile() {  
	        try {  
	            File input = new File("input.html");  
	            Document doc = Jsoup.parse(input, "UTF-8");  
	            // 提取body标签下的所有标签  
	            Element codes = doc.body();  
	            System.out.println(codes);  
	            System.out.println("------------------");  
	            System.out.println(codes.html());  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	}  
