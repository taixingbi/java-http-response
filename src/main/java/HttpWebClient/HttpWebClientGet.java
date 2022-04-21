package HttpWebClient;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class HttpWebClientGet {
    static String uri= "https://httpbin.org/get";

    public static void main(String[] args) throws Exception {
        System.out.println("----------------http get------------------");
        get();
        System.out.println("----------------http get------------------");
    }

    public static void get() {
        WebClient webClient = WebClient.builder()
                .baseUrl( uri )
//                .defaultHeaders(new Consumer<HttpHeaders>() {
//                    @Override
//                    public void accept(HttpHeaders httpHeaders) {
//                        httpHeaders.addAll(createHeaders("eyJ0eXAiOiJKV1...."));
//                    }
//                })
                .build();

        Mono<String> response = webClient.get().retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(100_000));
        String reponsePayload = response.block();
        System.out.println("HttpResponseService getSync: " + reponsePayload);
    }

    private static HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/csv");
        headers.add(HttpHeaders.AUTHORIZATION, token);
        return headers;
    }
}
