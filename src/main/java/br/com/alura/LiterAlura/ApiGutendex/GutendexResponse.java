package br.com.alura.LiterAlura.ApiGutendex;

import br.com.alura.LiterAlura.Livro.Livro;

import java.util.List;

public class GutendexResponse {
    private Integer count;
    private List<Livro> results;

    // Getters e Setters
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Livro> getResults() {
        return results;
    }

    public void setResults(List<Livro> results) {
        this.results = results;
    }
}
