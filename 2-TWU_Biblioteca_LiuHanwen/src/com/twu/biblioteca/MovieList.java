package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franklau on 2018/7/13.
 */
public class MovieList {
    private List<Movie> ava_movies;
    private List<Movie> out_movies;

    public MovieList(){
        ava_movies = new ArrayList<Movie>();
        out_movies = new ArrayList<Movie>();
    }

    public List<Movie> getOutList(){
        return out_movies;
    }

    public List<Movie> getAvaList(){
        return ava_movies;
    }

    public boolean checkoutFromList(int movie_idx, User user){
        Movie mov = ava_movies.remove(movie_idx);
        boolean ret = mov.checkout(user);
        out_movies.add(mov);
        return ret;
    }

    public boolean returnFromList(String name, User user){
        for(Movie mov: out_movies){
            if (mov.getInfo().get("name").compareTo(name)==0 && mov.return_(user)){
                ava_movies.add(mov);
                return true;
            }
        }
        return false;
    }

    public String show(){

        if(ava_movies.size()==0){
            return Utils.NO_BOOK_WARNING.replaceAll("book", "movie");
        }

        String ret = "";
        for(int i = 0; i<ava_movies.size(); i+=1){
            ret+=String.format(Utils.ROW_FORMAT, i+1, ava_movies.get(i).show());
        }

        return ret;
    }

    public void add(Movie mov){
        ava_movies.add(mov);
    }

}
