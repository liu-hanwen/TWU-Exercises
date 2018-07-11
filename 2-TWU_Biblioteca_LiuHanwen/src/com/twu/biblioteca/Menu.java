package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franklau on 2018/7/11.
 */
public abstract class Menu {
    protected List<Menu> options;
    protected String name;

    public String getName(){
        return this.name;
    }

    public abstract void show();

    public String showOptions(){
        int nOption = this.options.size();
        String ret = "";
        for(int i=0; i<nOption; i+=1){
            ret+=String.format("%d.%s\n", i+1, options.get(i).getName());
        }
        return ret;
    }

    public abstract Menu doAction(String input);

}
