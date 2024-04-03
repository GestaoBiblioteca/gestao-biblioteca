package view;

import controller.LibraryDatabase;
import model.Book;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> BDLibrary;
    private Scanner scanner;

    public Library() {
        scanner = new Scanner(System.in);
    }

    LibraryDatabase libraryDB = new LibraryDatabase();
    ArrayList<Book> allBooks = libraryDB.getAllBooks();



    public void addBook() {
        System.out.println("Digite o título do livro:");
        String title = scanner.nextLine();

        System.out.println("Digite o autor do livro:");
        String author = scanner.nextLine();

        System.out.println("Digite a editora do livro:");
        String publisher = scanner.nextLine();

        System.out.println("Digite o ISBN do livro:");
        String isbn = scanner.nextLine();

        System.out.println("Digite a quantidade em estoque do livro:");
        int qttStock = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(title, author, publisher, isbn, qttStock);
        libraryDB.addBook(newBook);

        System.out.println("\nLivro adicionado: " + title + " por " + author);
    }

    public void listBooks(){
        if(allBooks.isEmpty()){
            System.out.println("Não há livros disponíveis na Biblioteca!");
            return;
        } else{
            System.out.println("\n Lista de livros disponíveis: \n");
            for(Book book : allBooks){
                System.out.println(book);
            }
        }
    }

    public void findBookByTitle() {
        System.out.println("Digite o título do livro que você está procurando:");

        String title = scanner.nextLine();
        ArrayList<Book> allBooks = libraryDB.getAllBooks();


        for (Book book : allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nLivro encontrado: " + book.getTitle() + " por " + book.getAuthor());

                System.out.println("\nTítulo: " + book.getTitle());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("Editora: " + book.getPublisher());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Quantidade: " + book.getQttStock());

                return;
            }
        }

        System.out.println("Não encontrado.");
    }

    public void findBookByAuthor() {
        System.out.println("\nDigite o autor do livro que você está procurando:");
        String author = scanner.nextLine();
        boolean foundBook = false;

        System.out.println("\nLista de livros encontrados do autor " + author + ":");

        for (Book book : allBooks) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.toString());
                foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void borrowBook() {
        System.out.println("Lista de livros disponíveis para emprestar:");
        for(Book book : allBooks){
            System.out.println(book);
        }

        System.out.println("Digite o título do livro que você deseja emprestar:");
        String title = scanner.nextLine();

        for (Book book : allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getQttStock() > 0) {
                    book.setQqtStock(book.getQttStock() - 1);
                    System.out.println("\nVocê emprestou o livro: " + book.getTitle());
                    System.out.println("Quantidade atual do livro " + book.getTitle() + ": " + book.getQttStock());
                    System.out.println("\nVoltando ao menu anterior.");
                    return;
                } else {
                    System.out.println("\nDesculpe, o livro " + book.getTitle() + " está fora de estoque.");
                    System.out.println("Voltando ao menu.");
                    return;
                }
            }
        }

        System.out.println("Livro não encontrado.");
    }

    public void returnBook() {
        System.out.println("Digite o título do livro que você deseja devolver:");
        String title = scanner.nextLine();

        ArrayList<Book> allBooks = libraryDB.getAllBooks();

        for (Book book : allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setQqtStock(book.getQttStock() + 1);
                System.out.println("\n Você devolveu o livro: " + book.getTitle());
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }




    public void menuUser() {
        while(true){
            System.out.println("\n1. Adicionar livro");
            System.out.println("2. Listar livros disponíveis");
            System.out.println("3. Buscar livro por título");
            System.out.println("4. Buscar livro por autor");
            System.out.println("5. Emprestar livro");
            System.out.println("6. Devolver livro");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 1 para utilizar o sistema pelo console");
        System.out.println("Digite 2 para utilizar o sistema através da interface gráfica");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Library library = new Library();
                library.menuUser();
                break;
            case 2:
                LibraryGUI h = new LibraryGUI();

                URL url = Library.class.getResource("../resources/icon/icon.jpg");
                ImageIcon icon = new ImageIcon(url);

                h.setIconImage(icon.getImage());
                h.setContentPane(h.getPanelMain());
                h.setTitle("Sistema de Gestão de Biblioteca");
                h.setExtendedState(h.MAXIMIZED_BOTH);
                h.setSize(800, 600);
                h.setVisible(true);
                h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
