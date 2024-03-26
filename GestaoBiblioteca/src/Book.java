public class Book {
        public String titulo;
        public String autor;
        public String editora;
        public String isbn;
        public Integer qqtEstoque;
    
    
        public Book(String titulo, String autor, String editora, String isbn, Integer qqtEstoque){
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.sbn = isbn;
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
        

    
        public void setIsbn(String isbn) {
            this.sbn = isbn;
        }
        

    
        public void setQqtEstoque(Integer qqtEstoque) {
            this.qqtEstoque = qqtEstoque;
        }


        public String toString() {
            return "Livro{\n" +
                   "    titulo='" + titulo + "',\n" +
                   "     autor='" + autor + "',\n" +
                   "     editora='" + editora + "',\n" +
                   "     isbn='" + isbn + "',\n" +
                   "     qqtEstoque=" + qqtEstoque + "\n" +
                    "}";
        }
           
}