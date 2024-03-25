import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        
        AddBooks addBooks = new AddBooks();
        addBooks.adicionarLivro(titulo, autor);


        scanner.close();
    }
}
