package com.twu.biblioteca.Menu.Option;

import com.twu.biblioteca.Menu.BaseMenu;

/**
 * Created by franklau on 2018/7/11.
 */
public class BaseOption extends BaseMenu {

    public BaseOption(String name){
        this.name = name;
    }

    @Override
    public void show(){};

    @Override
    public BaseMenu doAction(String input) {
        return null;
    }
}
