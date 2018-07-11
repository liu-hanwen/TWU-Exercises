package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/12.
 */
public class QuitOption extends Options{

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
    public Menu doAction(String input) {
        return null;
    }
}
