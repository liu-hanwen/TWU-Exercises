package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by franklau on 2018/7/11.
 */
public class BookList {
    private List<Book> booklist;

    public BookList(){
        booklist = new ArrayList<Book>();
    }

    public void add(Book book){
        booklist.add(book);
    }

    public String show(){
        String ret = "";

        List<Book> ava = getAvaList();
        int listSize = ava.size();

        if(listSize==0){return Utils.NO_BOOK_WARNING;}

        for(int j = 0; j<listSize; j+=1){
            ret += String.format(Utils.ROW_FORMAT, j + 1, ava.get(j).show());
        }

        return ret;
    }

    public boolean[] whichAreAvaliable(){
        boolean[] ret = new boolean[booklist.size()];
        for(int i = 0; i<booklist.size(); i+=1){
            ret[i] = booklist.get(i).ifAvaliable();
        }
        return ret;
    }

    public List<Book> getOutList(){
        List<Book> ret = new ArrayList<Book>();
        boolean[] ava = whichAreAvaliable();
        for(int i =0; i<booklist.size(); i+=1){
            if(!ava[i]){ret.add(booklist.get(i));}
        }
        return ret;
    }

    public List<Book> getAvaList(){
        List<Book> ret = new ArrayList<Book>();
        boolean[] ava = whichAreAvaliable();
        for(int i =0; i<booklist.size(); i+=1){
            if(ava[i]){ret.add(booklist.get(i));}
        }
        return ret;
    }


}
