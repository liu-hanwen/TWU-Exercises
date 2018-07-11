package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {

    @Test
    public void test() {
        assertEquals("Welcome to use Biblioteca!", BibliotecaApp.sayWelcome());
    }
}
