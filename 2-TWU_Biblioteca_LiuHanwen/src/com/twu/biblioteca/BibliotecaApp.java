package com.twu.biblioteca;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.SubMenu.BooksMenu;
import com.twu.biblioteca.Menu.SubMenu.HomeMenu;
import com.twu.biblioteca.Menu.SubMenu.LoginMenu;
import com.twu.biblioteca.Menu.SubMenu.MoviesMenu;

import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BaseMenu current = LoginMenu.getInstance();

        usersInit();
        booklistInit();
        movielistInit();


        while(true){
            current.show();
            String input = scan.nextLine();
            current = current.doAction(input);
        }
    }

    private static void usersInit(){
        User[] users = {new User("admin", "admin"), new User("guest", "guest")};
        HashMap<String, String> info = new HashMap<String, String>();
        info.put("Name", "Lucy");
        info.put("E-mail", "lucy@lucy");
        info.put("Address", "Hongkong, RPC.");
        users[0].setUserInfo(info);
        User.addUser(users[0]);
        User.addUser(users[1]);

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

    private static void movielistInit(){
        MovieList list = new MovieList();
        Movie mov1 = new Movie("mov1", "1998", "Lee", "4");
        Movie mov2 = new Movie("mov2", "1993", "Lau", "3");
        Movie mov3 = new Movie("mov3", "1992", "Blue", "7");
        list.add(mov1);
        list.add(mov2);
        list.add(mov3);
        MoviesMenu.getInstance().setMovieList(list);
    }

    public static String sayWelcome(){
        return Utils.WELCOME;
    }


}
