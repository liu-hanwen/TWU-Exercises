package com.twu.biblioteca;


import com.twu.biblioteca.Menu.SubMenu.*;
import com.twu.biblioteca.Menu.Option.QuitOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void optionsShowTest(){
        BooksMenu.getInstance().setBookList(new BookList());
        assertEquals("1.List all books.\n2.List all movies.\n3.Account Information.\n4.Quit.\n", HomeMenu.getInstance().showOptions());
        assertEquals("1.Check out.\n2.Return an item.\n3.Back to home.\n4.Quit.\n", BooksMenu.getInstance().showOptions());
        assertEquals("1.Check out.\n2.Return an item.\n3.Back to home.\n4.Quit.\n", MoviesMenu.getInstance().showOptions());
    }

    @Test
    public void jumpTest(){
        assertEquals(BooksMenu.getInstance(), HomeMenu.getInstance().doAction("1")); //home -> booksmenu
        assertEquals(HomeMenu.getInstance(), BooksMenu.getInstance().doAction("3").doAction("y")); //booksmenu -redirect-> home
    }

    @Test
    public void quitTest(){
        assertEquals(QuitOption.getInstance(),BooksMenu.getInstance().doAction("4"));
    }

    @Test
    public void invaildInputTest(){
        assertEquals(HomeMenu.getInstance(), HomeMenu.getInstance().doAction("???"));

        assertEquals(BooksMenu.getInstance(), BooksMenu.getInstance().doAction("???"));
        assertEquals(MoviesMenu.getInstance(), MoviesMenu.getInstance().doAction("???") );

        assertEquals(BooksCheckMenu.getInstance(), BooksCheckMenu.getInstance().doAction("???"));
        assertEquals(MoviesCheckMenu.getInstance(),MoviesCheckMenu.getInstance().doAction("???"));

//        assertEquals(BooksMenu.getInstance(), BooksReturnMenu.getInstance().doAction("???"));
//        assertEquals(MoviesMenu.getInstance(), MoviesReturnMenu.getInstance().doAction("???"));
    }


}
