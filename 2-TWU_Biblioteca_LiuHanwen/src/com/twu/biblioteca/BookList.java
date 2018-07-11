package com.twu.biblioteca;

import java.util.ArrayList;
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
        int i = 0;
        int listSize = this.booklist.size();

        if(listSize==0){return "There is no books in the list!\n";}

        while(i<listSize){
            Book target = booklist.get(i);
            //todo: check out judgement
            ret+=String.format("%d.%s\n", i+1, target.show());
            i+=1;
        }
        return ret;
    }


}
