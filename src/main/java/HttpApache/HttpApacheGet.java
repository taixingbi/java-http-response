package HttpApache;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpApacheGet {
    static String uri= "https://httpbin.org/get";

    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {
        System.out.println("----------------Http Apache Get start ------------------");
        get();
        System.out.println("----------------Http Apache Get end------------------");
    }

    public static void get() throws Exception {
        HttpGet httpget = new HttpGet(uri);// get method
//        httpget.addHeader(AUTHORIZATION, TOKEN);
        HttpResponse httpresponse = httpclient.execute(httpget);

        String payload= handleResponse(httpresponse);
        System.out.println("payload: " + payload);

        httpclient.close();
    }

    public static String handleResponse(final HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            if(entity == null) {
                return "";
            } else {
                return EntityUtils.toString(entity);
            }

        } else {
            return ""+status;
        }
    }
}
