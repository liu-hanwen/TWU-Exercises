package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/12.
 */
public class BackToHome extends Options {
    String current;

    public BackToHome(String current){
        super("Back to home.");
        this.current = current;
    }

    @Override
    public void show() {
        System.out.println("Back to home page please insert 'y'. Anything else will let you stay here.");
    }

    @Override
    public Menu doAction(String input) {
        if (input.compareTo("y")==0){return HomeMenu.getInstance();}
        else if (current.compareTo("BooksMenu")==0){return BooksMenu.getInstance();}
        else{return null;}
    }
}
