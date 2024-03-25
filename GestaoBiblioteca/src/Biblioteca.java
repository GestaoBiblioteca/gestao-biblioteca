package src;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();

        System.out.println("Digite a editora do livro:");
        String editora = scanner.nextLine();

        System.out.println("Digite o sbn do livro:");
        String sbn = scanner.nextLine();

        System.out.println("Digite a quantidade em estoque do livro:");
        Integer qqtEstoque = scanner.nextInt();
        

        AddBooks addBooks = new AddBooks();
        addBooks.adicionarLivro(titulo, autor, editora, sbn, qqtEstoque);


        scanner.close();
    }
}
