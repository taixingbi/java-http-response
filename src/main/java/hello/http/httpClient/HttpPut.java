package hello.http.httpClient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPut {
    static String uri= "https://httpbin.org/put";

    public static void put(String data)   {
        HttpURLConnection http = httpConfig();

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = null;

        try {
            stream = http.getOutputStream();
            stream.write(out);
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        http.disconnect();
    }

    private static HttpURLConnection httpConfig() {
        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection http = null;
        try {
            http = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            http.setRequestMethod("PUT");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");
        return http;
    }
}
