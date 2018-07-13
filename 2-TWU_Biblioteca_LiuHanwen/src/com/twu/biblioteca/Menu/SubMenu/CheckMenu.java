package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookList;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Utils;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by franklau on 2018/7/12.
 */
public class CheckMenu extends BaseMenu{
    private static CheckMenu me;

    private CheckMenu(){
        this.name = Utils.CHECKMENU_NAME;
    }

    public static CheckMenu getInstance(){
        if(me==null){
            me = new CheckMenu();
        }
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.BOOKS_CHECK_GUIDE);
    }

    @Override
    public BaseMenu doAction(String input) {
        try{
            int choice = Integer.parseInt(input);
            List<Book> ava = BooksMenu.getInstance().getBooklist().getAvaList();
            if (!ava.get(choice-1).checkout()){
                throw new Exception(Utils.CHECK_FAILED_ERROR);
            }
            else{
                System.out.println(Utils.CHECK_OK);
                return BooksMenu.getInstance();
            }

        }
        catch (Exception e){
            if(e.getMessage().compareTo(Utils.CHECK_FAILED_ERROR)==0){
                System.out.println(Utils.CHECK_FAILED_ERROR);
            }
            else{
                System.out.println(Utils.INVAILD_ERROR);
            }
//            System.out.println("DEBUG");
            return me;
        }
    }
}
