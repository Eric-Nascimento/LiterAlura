package br.com.alura.LiterAlura.HTTP;

import java.net.http.HttpClient;

public class HttpClientConfig {
    private final HttpClient httpClient;

    public HttpClientConfig() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }
}