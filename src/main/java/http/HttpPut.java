package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// create
public class HttpPut {
    static String uri= "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

    public static void main(String[] args){
        System.out.println("----------------http put------------------");
        String data = "{\n  \"Id\": 12345,\n  \"Customer\": \"John Smith\",\n  \"Quantity\": 1,\n  \"Price\": 10.00\n}";

        putSync(data);
        System.out.println("----------------http put------------------");
    }

    public static void putSync(String data){
        System.out.println("putSync");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
//                .header(     "Accept", "application/csv")
//                .header(     "Authorization", authorization)
                .PUT(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        String body= response.body();
        System.out.println("body: \n" + body);
    }

    public static void putAsync(String data) {
        System.out.println("putAsync");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
//                .header(     "Accept", "application/csv")
//                .header(     "Authorization", authorization)
                .uri(URI.create(uri))
                .PUT(HttpRequest.BodyPublishers.ofString(data))
                .build();

        String result= client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
                .join();

        System.out.println("HttpResponseService getAsync: "+ result);
    }
}

