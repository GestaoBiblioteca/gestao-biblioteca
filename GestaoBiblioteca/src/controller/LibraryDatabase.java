package src.controller;

import src.model.Book;

import java.util.ArrayList;

public class LibraryDatabase {
    public ArrayList<Book> books;

    public LibraryDatabase(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

}
