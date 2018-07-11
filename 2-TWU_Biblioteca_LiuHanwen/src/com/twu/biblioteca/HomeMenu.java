package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by franklau on 2018/7/11.
 */
public class HomeMenu extends Menu {

    private static HomeMenu me;

    private HomeMenu(){
        this.name = "Home";
        this.options = new ArrayList<Menu>();
        this.options.add(BooksMenu.getInstance());
        this.options.add(QuitOption.getInstance());
    }

    public static HomeMenu getInstance(){
        if(me==null){
            me = new HomeMenu();
        }
        return me;

    }

    @Override
    public void show(){
        System.out.println(BibliotecaApp.sayWelcome());
        System.out.println(String.format("=====%s=====", me.getName()));
        System.out.print(this.showOptions());
        System.out.println("Please insert your selection:");
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
