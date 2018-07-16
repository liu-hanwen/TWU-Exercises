package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Utils;

import java.util.List;

/**
 * Created by franklau on 2018/7/16.
 */
public class MoviesReturnMenu extends BaseMenu {
    private static MoviesReturnMenu me;

    private MoviesReturnMenu(){
        this.name = Utils.RETURNMENU_NAME;
    }

    public static MoviesReturnMenu getInstance(){
        if(me==null){me = new MoviesReturnMenu();}
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.MOVIES_RETURN_GUIDE);
    }

    @Override
    public BaseMenu doAction(String input) {

        if(MoviesMenu.getInstance().getMovielist().returnFromList(input, LoginMenu.getCurUser())){
            System.out.println(Utils.RETURN_OK);
            return MoviesMenu.getInstance();
        }
        else{
            System.out.println(Utils.RETURN_FAILED_ERROR);
            return MoviesMenu.getInstance();
        }

    }



}
