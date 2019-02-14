package com.twu.biblioteca;
import java.io.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ExampleTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
}
