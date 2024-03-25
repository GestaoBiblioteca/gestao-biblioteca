import java.util.ArrayList;

public class AddBooks {
    public void adicionarLivro(String titulo, String autor) {
        Livro novoLivro;
        System.out.println("Livro adicionado: " + titulo + " por " + autor);
        ArrayList<Livro> BDLibary = new ArrayList<>();
        BDLibary.add(titulo);
        BDLibary.add(autor);
        System.out.println("Livro cadastrado: "  + BDLibary.get(0));
        System.out.println("Livro cadastrado: "  + BDLibary.get(1));
        
    }
}
