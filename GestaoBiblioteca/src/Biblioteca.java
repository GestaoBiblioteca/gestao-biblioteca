package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> BDLibrary;
    private Scanner scanner;

    public Biblioteca() {
        BDLibrary = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarLivro() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();

        System.out.println("Digite a editora do livro:");
        String editora = scanner.nextLine();

        System.out.println("Digite o ISBN do livro:");
        int isbn = scanner.nextInt();

        System.out.println("Digite a quantidade em estoque do livro:");
        int qtdEstoque = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do scanner

        Livro novoLivro = new Livro(titulo, autor, editora, isbn, qtdEstoque);
        BDLibrary.add(novoLivro);

        System.out.println("Livro adicionado: " + titulo + " por " + autor);
    }

    public void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro que você está procurando:");
        String titulo = scanner.nextLine();

        for (Livro livro : BDLibrary) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Livro encontrado: " + livro.getTitulo() + " por " + livro.getAutor());
                return;
            }
        }
    } // Adicionei esta chave aqui

    public void buscarLivroPorAutor() {
        System.out.println("Digite o autor do livro que você está procurando:");
        String autor = scanner.nextLine();

        for (Livro livro : BDLibrary) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Livro encontrado: " + livro.getTitulo() + " por " + livro.getAutor());
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    public void emprestarLivro() {
        System.out.println("Digite o título do livro que você deseja emprestar:");
        String titulo = scanner.nextLine();

        for (Livro livro : BDLibrary) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.getQtdEstoque() > 0) {
                    livro.setQtdEstoque(livro.getQtdEstoque() - 1);
                    System.out.println("Você emprestou o livro: " + livro.getTitulo());
                    return;
                } else {
                    System.out.println("Desculpe, este livro está fora de estoque.");
                    return;
                }
            }
        }

        System.out.println("Livro não encontrado.");
    }

    public void devolverLivro() {
        System.out.println("Digite o título do livro que você deseja devolver:");
        String titulo = scanner.nextLine();

        for (Livro livro : BDLibrary) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setQtdEstoque(livro.getQtdEstoque() + 1);
                System.out.println("Você devolveu o livro: " + livro.getTitulo());
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }




public void menuUsuario() {
    while (true) {
        System.out.println("\n1. Adicionar livro");
        System.out.println("2. Buscar livro por título");
        System.out.println("3. Buscar livro por autor");
        System.out.println("4. Emprestar livro");
        System.out.println("5. Devolver livro");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  

        switch (opcao) {
            case 1:
                adicionarLivro();
                break;
            case 2:
                buscarLivroPorTitulo();
                break;
            case 3:
                buscarLivroPorAutor();
                break;
            case 4:
                emprestarLivro();
                break;
            case 5:
                devolverLivro();
                break;
            case 6:
                System.out.println("Saindo...");
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}


    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.menuUsuario();
    }
}
