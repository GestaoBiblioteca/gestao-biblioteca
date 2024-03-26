package src;
import java.util.ArrayList;

public class AddBooks {
    public void PushBook(String titulo, String autor, String editora, String sbn, Integer qqtEstoque) {
        Book newBook= new Book(titulo, autor, editora, sbn, qqtEstoque);
        System.out.println("Livro adicionado: " + titulo + " por " + autor);
        ArrayList<Livro> BDLibrary = new ArrayList<>();
        BDLibrary.add(newBook);
        System.out.println("Livro cadastrado: "  + BDLibrary.get(0));
        
    }
}


