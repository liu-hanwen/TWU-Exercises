package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Utils;
import com.twu.biblioteca.Book;


import java.util.List;

/**
 * Created by franklau on 2018/7/13.
 */
public class ReturnMenu extends BaseMenu{
    private static ReturnMenu me;

    private ReturnMenu(){
        this.name = Utils.RETURNMENU_NAME;
    }

    public static ReturnMenu getInstance(){
        if(me==null){me = new ReturnMenu();}
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.BOOKS_RETURN_GUIDE);
    }

    @Override
    public BaseMenu doAction(String input) {
        List<Book> out = BooksMenu.getInstance().getBooklist().getOutList();
        for(Book book: out){
            if(book.getName().compareTo(input)==0){
                if(book.return_()){
                    System.out.println(Utils.RETURN_OK);
                    return BooksMenu.getInstance();
                }
                else{
                    System.out.println(Utils.RETURN_FAILED_ERROR);
                    return me;
                }
            }
        }
        System.out.println(Utils.RETURN_FAILED_ERROR);
        return me;
    }
}