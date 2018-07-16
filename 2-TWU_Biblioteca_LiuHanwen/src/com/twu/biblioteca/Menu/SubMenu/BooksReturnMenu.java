package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Utils;
import com.twu.biblioteca.Book;


import java.util.List;

/**
 * Created by franklau on 2018/7/13.
 */
public class BooksReturnMenu extends BaseMenu{
    private static BooksReturnMenu me;

    private BooksReturnMenu(){
        this.name = Utils.RETURNMENU_NAME;
    }

    public static BooksReturnMenu getInstance(){
        if(me==null){me = new BooksReturnMenu();}
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
                if(book.return_(LoginMenu.getInstance().getCurUser())){
                    System.out.println(Utils.RETURN_OK);
                    return BooksMenu.getInstance();
                }
                else{
                    System.out.println(Utils.RETURN_FAILED_ERROR);
                    return BooksMenu.getInstance();
                }
            }
        }
        System.out.println(Utils.RETURN_FAILED_ERROR);
        return BooksMenu.getInstance();
    }



}