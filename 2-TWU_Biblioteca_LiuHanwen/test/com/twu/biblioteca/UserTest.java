package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userAuthTest() {
        User user = new User("admin", "admin");
        assertEquals(true, user.auth("admin"));
    }
}
