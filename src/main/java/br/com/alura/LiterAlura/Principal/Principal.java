package br.com.alura.LiterAlura.Principal;

import java.util.Scanner;

public class Principal {
    
    private final Scanner leitura = new Scanner(System.in);
    
    public void exibeMenu(){
        int opcao = -1;
        
        while (opcao != 9){
            var menu = """
                    *** Aplicativo de Literatura ***
                    
                    Escolha uma opção: 
                    
                    1 - Buscar livro por título
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros em determinado idioma
                    
                    9 - Sair
                    """;
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
        System.out.println("listará aqui o listar livros cadastrados");
    }

    private void buscarLivro() {
        System.out.println("listará aqui o livro buscado ");
    }
}
