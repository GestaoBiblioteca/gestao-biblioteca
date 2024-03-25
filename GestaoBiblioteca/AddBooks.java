import java.util.ArrayList;

public class AddBooks {
    public void adicionarLivro(String titulo, String autor) {
        Livro novoLivro;
        System.out.println("Livro adicionado: " + titulo + " por " + autor);
        ArrayList<String> BDLibrary = new ArrayList<>();
        BDLibrary.add(titulo);
        BDLibrary.add(autor);
        System.out.println("Livro cadastrado: "  + BDLibrary.get(0));
        System.out.println("Livro cadastrado: "  + BDLibrary.get(1));
        
    }
}
