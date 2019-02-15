package com.twu.biblioteca;

public class Book {

    private String title;
    private int publicationYear;
    private String author;

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
}
