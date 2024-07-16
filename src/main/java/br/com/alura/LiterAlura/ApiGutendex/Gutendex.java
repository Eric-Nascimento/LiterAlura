package br.com.alura.LiterAlura.ApiGutendex;

import br.com.alura.LiterAlura.Livro.Livro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gutendex {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public Gutendex() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<Livro> buscarLivro(String busca) throws IOException, InterruptedException, URISyntaxException {
        String url = "https://gutendex.com/books?search=" + busca.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return parseResponse(response.body());
    }

    private List<Livro> parseResponse(String responseBody) throws IOException {
        JsonNode root = objectMapper.readTree(responseBody);
        List<Livro> livros = new ArrayList<>();

        for (JsonNode book : root.path("results")) {
            Livro livro = new Livro();
            livro.setTitulo(book.path("title").asText());

            StringBuilder autores = new StringBuilder();
            book.path("authors").forEach(author -> autores.append(author.path("name").asText()).append(", "));
            livro.setAutor(autores.length() > 0 ? autores.substring(0, autores.length() - 2) : "Desconhecido");

            livros.add(livro);
        }
        return livros;
    }
}
