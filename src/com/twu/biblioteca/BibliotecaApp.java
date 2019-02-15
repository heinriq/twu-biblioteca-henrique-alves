package com.twu.biblioteca;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        String message =  "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
        System.out.println(message);
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void printMenu() {
        System.out.println("1: List all books");
    }

    public void selectOption(int option) {
        switch (option) {
            case 0:
                System.out.println("Exiting application.");
                break;
            case 1:
                listAllBooks();
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }

    public void listAllBooks() {
        for(int i=0; i<this.books.size(); i++) {
            System.out.println(this.books.get(i).getTitle());
        }
    }
}
