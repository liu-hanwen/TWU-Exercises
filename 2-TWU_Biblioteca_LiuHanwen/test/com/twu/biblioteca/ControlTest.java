package com.twu.biblioteca;


import com.twu.biblioteca.Menu.SubMenu.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlTest {

    @Test
    public void book_checkoutTest(){
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);
        BooksMenu.getInstance().setBookList(list);
        assertEquals(true, book2.ifAvaliable());
        assertEquals(BooksMenu.getInstance(), BooksCheckMenu.getInstance().doAction("2"));
        assertEquals(false, book2.ifAvaliable());
        assertEquals(BooksMenu.getInstance(), BooksCheckMenu.getInstance().doAction("2"));
        assertEquals(false, book3.ifAvaliable());

    }

    @Test
    public void book_returnTest(){
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);

        BooksMenu.getInstance().setBookList(list);
        assertEquals(BooksMenu.getInstance(), BooksCheckMenu.getInstance().doAction("2"));
        assertEquals(false, book2.ifAvaliable());
        assertEquals(BooksMenu.getInstance(), BooksReturnMenu.getInstance().doAction("book2"));
        assertEquals(true, book2.ifAvaliable());
        assertEquals(BooksMenu.getInstance(), BooksReturnMenu.getInstance().doAction("book2"));
    }


    @Test
    public void mov_checkoutTest(){
        Movie mov = new Movie("a movie", "1998", "Tommy", "5");
        Movie mov2 = new Movie("another movie", "1988", "Tom", "6");
        MovieList ml = new MovieList();
        ml.add(mov);
        ml.add(mov2);

        MoviesMenu.getInstance().setMovieList(ml);
        assertEquals(true, mov2.ifAvaliable());
        assertEquals(MoviesMenu.getInstance(), MoviesCheckMenu.getInstance().doAction("2"));
        assertEquals(false, mov2.ifAvaliable());
    }

    @Test
    public void mov_returnTest(){
        Movie mov = new Movie("a movie", "1998", "Tommy", "5");
        Movie mov2 = new Movie("another movie", "1988", "Tom", "6");
        MovieList ml = new MovieList();
        ml.add(mov);
        ml.add(mov2);

        MoviesMenu.getInstance().setMovieList(ml);
        assertEquals(true, mov2.ifAvaliable());
        assertEquals(MoviesMenu.getInstance(), MoviesCheckMenu.getInstance().doAction("2"));
        assertEquals(false, mov2.ifAvaliable());
        assertEquals(MoviesMenu.getInstance(), MoviesReturnMenu.getInstance().doAction("another movie"));
        assertEquals(true, mov2.ifAvaliable());
        assertEquals(MoviesMenu.getInstance(), MoviesReturnMenu.getInstance().doAction("another movie"));
    }

    @Test
    public void cheackableAuthTest(){

        User.addUser(new User("admin", "admin"));
        User.addUser(new User("guest", "guest"));

        Movie mov = new Movie("a movie", "1998", "Tommy", "5");
        Book book = new Book("book1", "author1", "2018");

        MovieList mov_list = new MovieList();
        BookList book_list = new BookList();

        mov_list.add(mov);
        book_list.add(book);

        MoviesMenu.getInstance().setMovieList(mov_list);
        BooksMenu.getInstance().setBookList(book_list);


        LoginMenu.getInstance().doAction("admin/admin");
        assertEquals(MoviesMenu.getInstance(), MoviesCheckMenu.getInstance().doAction("1"));
        assertEquals(BooksMenu.getInstance(), BooksCheckMenu.getInstance().doAction("1"));
        assertEquals(MoviesMenu.getInstance(), MoviesReturnMenu.getInstance().doAction("a movie"));
        assertEquals(BooksMenu.getInstance(), BooksReturnMenu.getInstance().doAction("book1"));

        assertEquals(MoviesMenu.getInstance(), MoviesCheckMenu.getInstance().doAction("1"));
        assertEquals(BooksMenu.getInstance(), BooksCheckMenu.getInstance().doAction("1"));
        LoginMenu.getInstance().doAction("guest/guest");
        assertEquals(MoviesMenu.getInstance(), MoviesReturnMenu.getInstance().doAction("a movie"));
        assertEquals(BooksMenu.getInstance(), BooksReturnMenu.getInstance().doAction("book1"));
    }
}
