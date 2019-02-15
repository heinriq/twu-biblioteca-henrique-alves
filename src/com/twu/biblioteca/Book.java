package com.twu.biblioteca;

public class Book {

    private String title;
    private int publicationYear;
    private String author;
    private boolean checkOut;

    public void Book() {
        this.checkOut = false;
    }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return this.title; }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
        if (this.checkOut) { System.out.println("Thank you! Enjoy the book"); }
    }

    public boolean getCheckOut() { return this.checkOut; }
}
