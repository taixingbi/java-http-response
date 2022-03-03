package hello.http.httpClient;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPut {
    static String uri= "https://httpbin.org/put";

    public static void process() throws Exception {
        String data = "{\n  \"Id\": 12345,\n  \"Customer\": \"John Smith\",\n  \"Quantity\": 1,\n  \"Price\": 10.00\n}";

        URL url = new URL(uri);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("PUT");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
    }
}
