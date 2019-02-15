package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ExampleTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setBooksWithGameOfThronesMetaData() {
        for (int volume=1; volume<=7; volume++) {
            Book book = new Book();
            book.setTitle("Game of Thrones vol: " + volume);
            book.setPublicationYear(1995 + volume);
            book.setAuthor("George R. R. Martin");
            books.add(book);
        }
    }

    @Test
    public void oneMustBeEqualOne() {
        assertEquals(1, 1);
    }

    @Test
    public void welcomeMessageMustBeTheOneStopShop() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.main(null);
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!\n";
        assertThat(outContent.toString(), is(equalTo(welcomeMessage)));
    }

    @Test
    public void bookMustBeGameOfThrones() {
        Book book = new Book();
        book.setTitle("Game of Thrones");
        String title = "Game of Thrones";

        assertThat(title, is(equalTo(book.getTitle())));
    }

    @Test
    public void sizeOfBooksListMustBeSeven() {
        assertThat(7, is(equalTo(books.size())));
    }

    @Test
    public void allBooksMustBeGameOfThronesAndYourVolume() {
        for(int volume=0; volume<7; volume++) {
            assertThat("Game of Thrones vol: " + (volume + 1), is(equalTo(books.get(volume).getTitle())));
        }
    }

    @Test
    public void publicationYearOfAFirstBookMustBe1996(){
        int year = 1996;
        Book book = new Book();
        book.setTitle("Game of Thrones vol: 1");
        book.setPublicationYear(year);

        assertThat(year, is(equalTo(book.getPublicationYear())));
    }

    @Test
    public void authorOfBookMustBeGeorgeRRMartin(){
        String author = "George R. R. Martin";
        Book book = new Book();
        book.setAuthor(author);

        assertThat(author, is(equalTo(book.getAuthor())));
    }

    @Test
    public void authorOfAllGameOfThronesMustBeGeorgeRRMartinAndYearMutBe1996PlusVolumeNumber() {
        int firstYear = 1996;
        String author = "George R. R. Martin";
        for (int volume = 0; volume < 7; volume++) {
            assertThat(firstYear + volume, is(equalTo(books.get(volume).getPublicationYear())));
            assertThat(author, is(equalTo(books.get(volume).getAuthor())));
        }

    }

    @Test
    public void firstOptionFromMenuMustBeShowed(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String menuList = "1: List all books\n";
        bibliotecaApp.printMenu();
        assertThat(outContent.toString(), is(equalTo(menuList)));

    }

    @Test
    public void testSelectListAllBooksOption() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setBooks(books);
        bibliotecaApp.selectOption(1);
        String listBooks = "";

        for(int i=0;i<books.size();i++) {
            listBooks += books.get(i).getTitle() + "\n";
        }

        assertThat(outContent.toString(), is(equalTo(listBooks)));

    }

    @Test
    public void messageForInvalidOptionMustBeShowed() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setBooks(books);
        bibliotecaApp.selectOption(999);

        String message = "Please select a valid option!\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }

    @Test
    public void applicationMustBeQuited() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setBooks(books);
        bibliotecaApp.selectOption(0);

        String message = "Exiting application.\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }

    @Test
    public void bookMustBeCheckedout() {
        Book book = new Book();
        book.setCheckOut(true);

        assertThat(book.getCheckOut(), is(true));
    }

    @Test
    public void checkedOutBooksMustNotAppearInBooksList() {
        books.get(1).setCheckOut(true);
        String response = "Thank you! Enjoy the book\n";
        for(int i=0;i < books.size(); i++) {
            response += (i != 1)? books.get(i).getTitle() + "\n" : "";
        }

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setBooks(books);
        bibliotecaApp.listAllBooks();

        assertThat(outContent.toString(), is(equalTo(response)));
    }

    @Test
    public void successMessageMustBeShowedWhenABookBeCheckedOut() {
        Book book = new Book();
        book.setCheckOut(true);
        String message = "Thank you! Enjoy the book\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }

    @Test
    public void aFailureMessageMustBeShowedWhenABookIsCheckedOut() {
        Book book = new Book();
        book.setCheckOut(true);

        book.setCheckOut(true);
        String message = "Thank you! Enjoy the book\nSorry, that book is not available\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }

    @Test
    public void BookMustBeReturned() {
        Book book = new Book();
        book.setCheckOut(true);
        book.setCheckOut(false);

        assertThat(book.getCheckOut(), is(false));
    }

    @Test
    public void returnedBookMustBeListed() {
        books.get(1).setCheckOut(true);
        books.get(1).setCheckOut(false);

        String response = "Thank you! Enjoy the book\nThank you for returning the book\n";
        for(int i=0;i<books.size(); i++) {
            response += books.get(i).getTitle() + "\n";
        }

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setBooks(books);
        bibliotecaApp.listAllBooks();

        assertThat(outContent.toString(), is(equalTo(response)));
    }

    @Test
    public void notificationForSuccessMustBeReturned() {
        Book book = new Book();
        book.setCheckOut(true);
        book.setCheckOut(false);
        String message = "Thank you! Enjoy the book\nThank you for returning the book\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }

    @Test
    public void onUnsuccessfulReturnANotificationMustBeShowed() {
        Book book = new Book();
        book.setTitle("Leviatan");
        book.setCheckOut(false);
        String message = "This is not a valid book to return\n";

        assertThat(outContent.toString(), is(equalTo(message)));
    }
}
