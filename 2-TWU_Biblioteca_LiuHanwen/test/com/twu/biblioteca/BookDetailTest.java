package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookDetailTest {

    @Test
    public void detailShowTest() {
        Book book = new Book("How to do TDD?", "ThoughtWorks University", "2018");
        assertEquals("<How to do TDD?>\tThoughtWorks University\t2018", book.show());
    }

    @Test
    public void checkoutTest(){
        Book book = new Book("How to do TDD?", "ThoughtWorks University", "2018");
        assertEquals(true, book.ifAvaliable());
        book.checkout();
        assertEquals(false, book.ifAvaliable());
        assertEquals(false, book.checkout());
    }

}
