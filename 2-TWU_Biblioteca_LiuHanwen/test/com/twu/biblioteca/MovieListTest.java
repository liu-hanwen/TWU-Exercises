package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieListTest {

    @Test
    public void showTest() {
        Movie mov = new Movie("a movie", "1998", "Tommy", "5");
        Movie mov2 = new Movie("another movie", "1988", "Tom", "6");
        MovieList ml = new MovieList();
        assertEquals("There is no movies in the list!\n", ml.show() );
        ml.add(mov);
        ml.add(mov2);
        assertEquals("1.<a movie>\t1998\tTommy\t5\n2.<another movie>\t1988\tTom\t6\n", ml.show());
    }
}
