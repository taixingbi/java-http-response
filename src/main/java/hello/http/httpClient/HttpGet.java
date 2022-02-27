package hello.http.httpClient;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpGet {
    static String uri= "https://httpbin.org/get";

    public static void getSync() throws Exception {
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
//                .header(     "Accept", "application/csv")
//                .header(     "Authorization", authorization)
                .build();

        java.net.http.HttpResponse<String> response =
                client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

        String result= response.body();
        System.out.println("HttpResponseService getSync: " + result);
    }

    public static void getAsync(String uri) {
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
//                .header(     "Accept", "application/csv")
//                .header(     "Authorization", authorization)
                .uri(URI.create(uri))
                .build();

        String result= client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString())
                .thenApply(java.net.http.HttpResponse::body)
//                .thenAccept(System.out::println)
                .join();

        System.out.println("HttpResponseService getAsync: "+ result);
    }
}
