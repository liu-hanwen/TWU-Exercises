package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Utils;

import java.util.List;

/**
 * Created by franklau on 2018/7/16.
 */
public class MoviesCheckMenu extends BaseMenu{
    private static MoviesCheckMenu me;

    private MoviesCheckMenu(){
        this.name = Utils.CHECKMENU_NAME;
    }

    public static MoviesCheckMenu getInstance(){
        if(me==null){
            me = new MoviesCheckMenu();
        }
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.MOVIES_CHECK_GUIDE);
    }

    @Override
    public BaseMenu doAction(String input) {

        try{
            int choice = Integer.parseInt(input);
//            List<Movie> ava = MoviesMenu.getInstance().getMovielist().getAvaList();
            if (!MoviesMenu.getInstance().getMovielist().checkoutFromList(choice-1, LoginMenu.getCurUser())){
                throw new Exception(Utils.CHECK_FAILED_ERROR);
            }
            else{
                System.out.println(Utils.CHECK_OK);
                return MoviesMenu.getInstance();
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
