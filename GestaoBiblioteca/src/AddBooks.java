package src;
import java.awt.print.Book;
import java.util.ArrayList;

public class AddBooks {
    public void PushBook(String titulo, String autor, String editora, String isbn, Integer qqtEstoque) {
        Book newBook = new Book();
        System.out.println("Livro adicionado: " + titulo + " por " + autor);

        ArrayList<Book> BDLibrary = new ArrayList<>();

        BDLibrary.add(newBook);
        System.out.println("Livro cadastrado: "  + BDLibrary.get(0));
        
    }
}


