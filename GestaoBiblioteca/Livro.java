public class Livro {
        public String titulo;
        public String autor;
        public String editora;
        public String sbn;
        public int qqtEstoque;
    
    
        public Livro(String titulo, String autor, String editora, String sbn, int qqtEstoque){
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.sbn = sbn;
            this.qqtEstoque = qqtEstoque;
        }
    
         // Métodos getters e setters
         public String getTitulo() {
            return titulo;
        }
    
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    
         public String getAutor() {
            return autor;
        }
    
        public void setAutor(String autor) {
            this.autor = autor;
        }
    
        public String getEditora() {
            return editora;
        }
    
        public void setEditora(String editora) {
            this.editora = editora;
        }
        
        public String getSbn() {
            return sbn;
        }
    
        public void setSbn(String sbn) {
            this.sbn = sbn;
        }
        
        public int getQqtEstoque() {
            return qqtEstoque;
        }
    
        public void setQqtEstoque(int qqtEstoque) {
            this.qqtEstoque = qqtEstoque;
        }
           
}
