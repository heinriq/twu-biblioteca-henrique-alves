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
    public void BooksMustBeAddedWithGameOfThronesTitles() {
        for (int volume=1; volume<=7; volume++) {
            Book book = new Book();
            book.setTitle("Game of Thrones vol: " + volume);
            books.add(book);
        }
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void WelcomeMessageMustBeTheOneStopShop() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.main(null);
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!\n";
        assertThat(outContent.toString(), is(equalTo(welcomeMessage)));
    }

    @Test
    public void BookMustBeGameOfThrones() {
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
}
