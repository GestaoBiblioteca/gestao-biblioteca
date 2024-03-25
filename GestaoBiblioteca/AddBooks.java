import java.util.ArrayList;

public class AddBooks {
    public void adicionarLivro(String titulo, String autor, String editora, String sbn, int qqtEstoque) {
        Livro novoLivro = new Livro(titulo, autor, editora, sbn, qqtEstoque);
        System.out.println("Livro adicionado: " + titulo + " por " + autor);
        ArrayList<Livro> BDLibary = new ArrayList<>();
        BDLibary.add(novoLivro);
        System.out.println("Livro cadastrado: "  + BDLibary.get(0).getTitulo);
        
    }
}