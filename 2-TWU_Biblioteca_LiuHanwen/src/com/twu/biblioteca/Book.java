package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/11.
 */
public class Book {
    String name;
    String author;
    String pubYear;

    public Book(String name, String author, String pubYear){
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
    }

    public String show(){
        return String.format("<%s>\t%s\t%s",
                this.name,
                this.author,
                this.pubYear);
    }
}