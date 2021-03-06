package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.BackToHome;
import com.twu.biblioteca.BookList;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.Option.QuitOption;
import com.twu.biblioteca.Utils;

import java.util.ArrayList;

/**
 * Created by franklau on 2018/7/11.
 */
public class BooksMenu extends BaseMenu {
    private static BooksMenu me;
    private BookList booklist;

    private BooksMenu(){
        this.name = Utils.BOOKSMENU_NAME;
        this.options = new ArrayList<BaseMenu>();
        this.options.add(BooksCheckMenu.getInstance());
        this.options.add(BooksReturnMenu.getInstance());
        this.options.add(new BackToHome(Utils.BOOKSMENU_NAME));
        this.options.add(QuitOption.getInstance());
    }

    public void setBookList(BookList booklist){
        this.booklist = booklist;
    }

    public BookList getBooklist() {
        return booklist;
    }

    public static BooksMenu getInstance(){
        if(me==null){
            me  = new BooksMenu();
        }
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.BOOKS_LISTING_GUIDE);
        System.out.print(this.booklist.show());
        System.out.println(Utils.OPTION_SELECTION_GUIDE);
        System.out.print(this.showOptions());
    }

    @Override
    public BaseMenu doAction(String input) {
        try{
            int choice = Integer.parseInt(input);
            if(choice-1<0 || choice-1>options.size()){
                throw new ArrayIndexOutOfBoundsException();
            }
            return options.get(choice-1);
        }
        catch(Exception e){
            System.out.println(Utils.INVAILD_ERROR);
            return me;
        }
    }
}
