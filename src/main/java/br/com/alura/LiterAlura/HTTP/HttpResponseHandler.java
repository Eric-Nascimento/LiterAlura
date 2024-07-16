package br.com.alura.LiterAlura.HTTP;

import java.net.http.HttpResponse;

public class HttpResponseHandler {

    public void handleResponse(HttpResponse<String> response) {
        int statusCode = response.statusCode();
        System.out.println("Código de Status: " + statusCode);


        String responseBody = response.body();
        System.out.println("Corpo da Resposta: " + responseBody);

    }
}
