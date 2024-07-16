package br.com.alura.LiterAlura.Principal;

import br.com.alura.LiterAlura.ApiGutendex.Gutendex;
import br.com.alura.LiterAlura.Livro.Livro;
import br.com.alura.LiterAlura.Livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final Gutendex gutendex;

    @Autowired
    private LivroService livroService;

    public Principal(Gutendex gutendex) {
        this.gutendex = gutendex;
    }

    public void exibeMenu(){
        int opcao = -1;

        while (opcao != 9){
            var menu = """
                    \n*** Aplicativo de Literatura ***
                    
                    Escolha uma opção: 
                    
                    1 - Buscar livro por título ou autor
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros em determinado idioma
                    
                    9 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosIdioma();
                    break;

                case 9:
                    System.out.println("Programa encerrado!");
                    break;
            }
        }
    }

    private void listarLivrosIdioma() {
        System.out.println("listará aqui o listar livros idioma ");
    }

    private void listarAutoresVivos() {
        System.out.println("listará aqui o Listar autores vivos");
    }

    private void listarAutores() {
        System.out.println("listará aqui o listar todos os autores cadastrados");
    }

    private void listarLivros() {
        List<Livro> livros = livroService.listarLivros();
        livros.forEach(livro -> System.out.println(livro));
    }

    private void buscarLivro() {
        System.out.println("Digite o nome do livro que deseja buscar: ");
        String busca = leitura.nextLine();
        try {
            List<Livro> resultado = gutendex.buscarLivro(busca);
            resultado.forEach(livro -> System.out.println(livro));
        } catch (Exception e) {
            System.out.println("Erro ao buscar o livro " + busca + " :" + e.getMessage());
        }
    }
}
