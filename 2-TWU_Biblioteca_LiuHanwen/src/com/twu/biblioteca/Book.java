package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/11.
 */
public class Book {
    private String name;
    private String author;
    private String pubYear;
    private boolean avaliable;

    public Book(String name, String author, String pubYear){
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
        this.avaliable = true;
    }

    public boolean ifAvaliable(){
        return this.avaliable;
    }

    public boolean checkout(){
        if(ifAvaliable()){ this.avaliable = false; return true; }
        return false;
    }

    public boolean return_(){
        if(!ifAvaliable()){ this.avaliable = true; return true; }
        return false;
    }

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