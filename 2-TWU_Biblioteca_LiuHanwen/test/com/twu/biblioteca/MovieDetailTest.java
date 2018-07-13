package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieDetailTest {

    @Test
    public void test() {
        Movie mov = new Movie("a movie", "1998", "Tommy", "5");
        assertEquals("<a movie>\t1998\tTommy\t5", mov.show());
    }

}
