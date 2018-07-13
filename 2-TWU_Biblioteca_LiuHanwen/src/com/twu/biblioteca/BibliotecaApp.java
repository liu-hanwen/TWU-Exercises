package com.twu.biblioteca;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.SubMenu.BooksMenu;
import com.twu.biblioteca.Menu.SubMenu.HomeMenu;

import java.awt.*;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BaseMenu current = HomeMenu.getInstance();

        booklistInit();


        while(true){
            current.show();
            String input = scan.nextLine();
            current = current.doAction(input);
        }
    }

    private static void booklistInit() {
        BookList list = new BookList();
        Book book1 = new Book("book1", "author1", "2018");
        Book book2 = new Book("book2", "author2", "2010");
        Book book3 = new Book("book3", "author3", "2011");
        list.add(book1);
        list.add(book2);
        list.add(book3);
        BooksMenu.getInstance().setBookList(list);
    }

    public static String sayWelcome(){
        return Utils.WELCOME;
    }


}
