package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.Option.QuitOption;
import com.twu.biblioteca.Utils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;

/**
 * Created by franklau on 2018/7/11.
 */
public class HomeMenu extends BaseMenu {

    private static HomeMenu me;

    private HomeMenu(){
        this.name = Utils.HOME_NAME;
        this.options = new ArrayList<BaseMenu>();
        this.options.add(BooksMenu.getInstance());
        this.options.add(MoviesMenu.getInstance());
        this.options.add(InfoMenu.getInstance());
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
//        System.out.println(BibliotecaApp.sayWelcome());
        System.out.println(String.format("=====%s=====", me.getName()));
        System.out.print(this.showOptions());
        System.out.println("Please insert your selection:");
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
