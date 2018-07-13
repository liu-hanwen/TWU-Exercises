package com.twu.biblioteca;

import com.twu.biblioteca.Menu.SubMenu.BooksMenu;
import com.twu.biblioteca.Menu.SubMenu.HomeMenu;
import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.Option.BaseOption;

/**
 * Created by franklau on 2018/7/12.
 */
public class BackToHome extends BaseOption {
    String current;

    public BackToHome(String current){
        super(Utils.BACK_HOME_OPTION_NAME);
        this.current = current;
    }

    @Override
    public void show() {
        System.out.println("Back to home page please insert 'y'. Anything else will let you stay here.");
    }

    @Override
    public BaseMenu doAction(String input) {
        if (input.compareTo("y")==0){return HomeMenu.getInstance();}
        else if (current.compareTo(Utils.BOOKSMENU_NAME)==0){return BooksMenu.getInstance();}
        else{return null;}
    }
}
