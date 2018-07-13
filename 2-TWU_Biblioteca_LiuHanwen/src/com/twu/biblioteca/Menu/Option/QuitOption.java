package com.twu.biblioteca.Menu.Option;

import com.twu.biblioteca.Menu.BaseMenu;

/**
 * Created by franklau on 2018/7/12.
 */
public class QuitOption extends BaseOption {

    private static QuitOption me;

    private QuitOption(){
        super("Quit.");
    }

    public static QuitOption getInstance(){
        if(me==null){
            me = new QuitOption();
        }
        return me;
    }

    @Override
    public void show() {
        System.exit(0);
    }

    @Override
    public BaseMenu doAction(String input) {
        return null;
    }
}
