package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/11.
 */
public class Options extends Menu {

    public Options(String name){
        this.name = name;
    }

    @Override
    public void show(){};

    @Override
    public Menu doAction(String input) {
        return null;
    }
}
