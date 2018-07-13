package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.Option.QuitOption;
import com.twu.biblioteca.Utils;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.User;


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

        String[] inputSplited = input.split("/");
        if(inputSplited.length!=3){
            System.out.println(Utils.INVAILD_ERROR);
            return me;
        }

        String book_name = inputSplited[0];
        String username = inputSplited[1];
        String password = inputSplited[2];

        User checker = Utils.checkUser(username, password);

        if(checker==null){
            System.out.println(Utils.USERNAME_OR_PASSWORD_ERROR);
            return me;
        }

        List<Book> out = BooksMenu.getInstance().getBooklist().getOutList();
        for(Book book: out){
            if(book.getName().compareTo(book_name)==0){
                if(book.return_(checker)){
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