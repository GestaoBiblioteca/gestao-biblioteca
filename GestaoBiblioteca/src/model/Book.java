package src.model;

public class Book {
        private String title;
        private String author;
        private String publisher;
        private String isbn;
        private Integer qqtStock;
    
    
        public Book(String title, String author, String publisher, String isbn, Integer qqtStock){
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.isbn = isbn;
            this.qqtStock = qqtStock;
        }
    

        public void setTitle(String title) {
            this.title = title;
        }
    

    
        public void setAuthor(String author) {
            this.author = author;
        }

    
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }
        

    
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
        

    
        public void setQqtStock(Integer qqtStock) {
            this.qqtStock = qqtStock;
        }


        public String toString() {
            return
                   "    Titulo: " + title + "\n" +
                   "    Autor: " + author + "\n" +
                   "    Editora: " + publisher + "\n" +
                   "    ISBN: " + isbn + "\n" +
                   "    Quantidade: " + qqtStock + "\n";
        }

        public String getTitle() {
                return title;
        }

        public String getAuthor() {
            return author;
        }

        public Integer getQttStock() {
            return qqtStock;
        }

        public String getISBN() {
            return isbn;
        }

        public String getPublisher() {
            return publisher;
        }
}