package br.com.alura.LiterAlura.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public void salvarLivros(List<Livro> livros) {
        livroRepository.saveAll(livros);
    }
}
