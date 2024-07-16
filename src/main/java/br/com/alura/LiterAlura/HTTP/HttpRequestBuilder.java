package br.com.alura.LiterAlura.HTTP;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

public class HttpRequestBuilder {

    public HttpRequest buildRequest(String busca) throws Exception {
        String url = "https://gutendex.com/books?search=" + busca.replace(" ", "%20");

        return HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
    }
}
