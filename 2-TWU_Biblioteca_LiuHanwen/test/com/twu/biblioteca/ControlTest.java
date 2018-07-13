package com.twu.biblioteca;


import com.twu.biblioteca.Menu.SubMenu.BooksMenu;
import com.twu.biblioteca.Menu.SubMenu.CheckMenu;
import com.twu.biblioteca.Menu.SubMenu.ReturnMenu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlTest {

    @Test
    public void checkoutTest(){
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);

        BooksMenu.getInstance().setBookList(list);

        assertEquals(true, book2.ifAvaliable());

        assertEquals(BooksMenu.getInstance(), CheckMenu.getInstance().doAction("2"));

        assertEquals(false, book2.ifAvaliable());

        assertEquals(BooksMenu.getInstance(), CheckMenu.getInstance().doAction("2"));

        assertEquals(false, book3.ifAvaliable());

    }

    @Test
    public void returnTest(){
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);

        BooksMenu.getInstance().setBookList(list);
        assertEquals(BooksMenu.getInstance(), CheckMenu.getInstance().doAction("2"));
        assertEquals(false, book2.ifAvaliable());
        assertEquals(BooksMenu.getInstance(), ReturnMenu.getInstance().doAction("book2"));
        assertEquals(true, book2.ifAvaliable());
        assertEquals(ReturnMenu.getInstance(), ReturnMenu.getInstance().doAction("book2"));
    }
}
