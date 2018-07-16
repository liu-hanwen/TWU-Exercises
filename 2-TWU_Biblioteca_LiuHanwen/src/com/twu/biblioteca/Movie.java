package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by franklau on 2018/7/13.
 */
public class Movie extends Checkable{
//    private String name;
//    private String year;
//    private String director;
//    private String rating;
    private HashMap<String, String> info;

    public Movie(String name, String year, String director, String rating){
        info = new HashMap<String, String>();
        info.put("name", name);
        info.put("year", year);
        info.put("director", director);
        info.put("rating", rating);
    }

    @Override
    public String show() {
        String ret = String.format("<%s>", info.get("name"));
        for(String key:info.keySet()){
            if(key.compareTo("name")==0){continue;}
            ret+=String.format("\t%s", info.get(key));
        }
        return ret;
    }

    public String getName(){
        return info.get("name");
    }

    public HashMap<String, String> getInfo() {
        return info;
    }
}
