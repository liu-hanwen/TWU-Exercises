package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksListingTest {

    @Test
    public void listingTest() {

        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);
        assertEquals("1.<book1>\tauthor1\t2018\n2.<book2>\tauthor2\t2010\n3.<book3>\tauthor3\t2011\n", list.show());
//        assertEquals("There is no books in the list!", list.show());
    }

    @Test
    public void unavaliableHiddingTest(){
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);
        book2.checkout(new User("1","1"));
        assertEquals("1.<book1>\tauthor1\t2018\n2.<book3>\tauthor3\t2011\n", list.show());

    }

    @Test
    public void emptyListTest(){
        BookList list = new BookList();
        assertEquals("There is no books in the list!\n", list.show());
    }
}
