import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        HttpMethod httpPost =getPostMethod();
        
        //HttpMethod httpPost =getGetMethod();
        client.getHostConfiguration().setHost("localhost", 8080, "http");
        try {
            int status = client.executeMethod(httpPost);
            if(status==200)
            {
//            	JFrame jf = new JFrame();
//            	JLabel jl = new JLabel();
//            	jl.setText(httpPost.getResponseBodyAsString());
//            	jf.add(jl);
//            	jf.setVisible(true);
            	
                System.out.println(httpPost.getResponseBodyAsString());
            }
            else
            {
            	
                System.out.println("页面请求返回值为："+status);
            }
        } catch (HttpException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }finally{
            httpPost.releaseConnection();
        }
    }
    /**
     * 使用POST方式提交数据
     * @return
     */
    private static HttpMethod getPostMethod(){
        PostMethod post = new PostMethod("/news/index.jsp");
        NameValuePair simcard = new NameValuePair("name1","1330227");
        NameValuePair simcard2 = new NameValuePair("name2","kjasdfklalsf");
        post.setRequestBody(new NameValuePair[] { simcard,simcard2});
        return post;
    }
    /**
     * 使用GET方式提交数据
     * @return
     */
    private static HttpMethod getGetMethod(){
        return new GetMethod("/PostTest/index.jsp?name1=1330227&name2=asdfsdf");
    }
}

