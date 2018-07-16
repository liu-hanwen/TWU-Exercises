package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.*;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.Option.QuitOption;

import java.util.ArrayList;

/**
 * Created by franklau on 2018/7/16.
 */
public class MoviesMenu extends BaseMenu{
    private static MoviesMenu me;
    private MovieList movieList;

    private MoviesMenu(){
        this.name = Utils.MOVIESMENU_NAME;
        this.options = new ArrayList<BaseMenu>();
        this.options.add(MoviesCheckMenu.getInstance());
        this.options.add(MoviesReturnMenu.getInstance());
        this.options.add(new BackToHome(Utils.MOVIESMENU_NAME));
        this.options.add(QuitOption.getInstance());
    }

    public void setMovieList(MovieList movieList){
        this.movieList = movieList;
    }

    public MovieList getMovielist() {
        return movieList;
    }

    public static MoviesMenu getInstance(){
        if(me==null){
            me  = new MoviesMenu();
        }
        return me;
    }

    @Override
    public void show() {
        System.out.println(Utils.MOVIES_LISTING_GUIDE);
        System.out.print(this.movieList.show());
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
