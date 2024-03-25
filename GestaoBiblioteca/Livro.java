public class Livro {
        public String titulo;
        public String autor;
        public String editora;
        public String sbn;
        public Integer qqtEstoque;
    
    
        public Livro(String titulo, String autor, String editora, String sbn, Integer qqtEstoque){
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.sbn = sbn;
            this.qqtEstoque = qqtEstoque;
        }
    

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    

    
        public void setAutor(String autor) {
            this.autor = autor;
        }

    
        public void setEditora(String editora) {
            this.editora = editora;
        }
        

    
        public void setSbn(String sbn) {
            this.sbn = sbn;
        }
        

    
        public void setQqtEstoque(Integer qqtEstoque) {
            this.qqtEstoque = qqtEstoque;
        }


        public String toString() {
            return "Livro{\n" +
                   "    titulo='" + titulo + "',\n" +
                   "     autor='" + autor + "',\n" +
                   "     editora='" + editora + "',\n" +
                   "     sbn='" + sbn + "',\n" +
                   "     qqtEstoque=" + qqtEstoque + "\n" +
                    "}";
        }
           
}