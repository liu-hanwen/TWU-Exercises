package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by franklau on 2018/7/11.
 */
public class BooksMenu extends Menu{
    private static BooksMenu me;
    private BookList booklist;

    private BooksMenu(){
        this.name = "List all books.";
        this.options = new ArrayList<Menu>();
        this.options.add(new Options("Check out a book."));
        this.options.add(new BackToHome("BooksMenu"));
        this.options.add(QuitOption.getInstance());
    }

    public void setBookList(BookList booklist){
        this.booklist = booklist;
    }

    public static BooksMenu getInstance(){
        if(me==null){
            me  = new BooksMenu();
        }
        return me;
    }

    @Override
    public void show() {
        System.out.println("Here is the book list(name/author/year):");
        System.out.print(this.booklist.show());
        System.out.println("Please insert your selection:");
        System.out.print(this.showOptions());
    }

    @Override
    public Menu doAction(String input) {
        try{
            int choice = Integer.parseInt(input);
            if(choice-1<0 || choice-1>options.size()){
                throw new ArrayIndexOutOfBoundsException();
            }
            return options.get(choice-1);
        }
        catch(Exception e){
            System.out.println("Error: Select a valid option!");
            return me;
        }
    }
}
