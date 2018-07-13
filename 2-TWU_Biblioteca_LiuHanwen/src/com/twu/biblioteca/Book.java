package com.twu.biblioteca;

import com.twu.biblioteca.Menu.SubMenu.CheckMenu;

/**
 * Created by franklau on 2018/7/11.
 */
public class Book extends Checkable {
    private String name;
    private String author;
    private String pubYear;

    public Book(String name, String author, String pubYear){
        super();
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
    }

    @Override
    public String show(){
        return String.format("<%s>\t%s\t%s",
                this.name,
                this.author,
                this.pubYear);
    }

    public String getName() {
        return name;
    }
}