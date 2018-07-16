package com.twu.biblioteca;


import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Menu.SubMenu.HomeMenu;
import com.twu.biblioteca.Menu.SubMenu.LoginMenu;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userAuthTest() {
        User user = new User("admin", "admin");
        assertEquals(true, user.auth("admin"));
    }

    @Test
    public void userLoginTest(){
        User.setAllUsers();
        User u1 = new User("admin", "888888");
        User.addUser(u1);
        assertEquals(HomeMenu.getInstance(), LoginMenu.getInstance().doAction("admin/888888"));
        assertEquals(u1, LoginMenu.getCurUser());
    }

    @Test
    public void userInfoTest(){
        User.setAllUsers();
        User u1 = new User("admin", "888888");
        assertEquals(Utils.INFO_NOT_SET_WARNING, u1.showInfo());
        HashMap<String, String> info = new HashMap<String, String>();
        info.put("Name", "Frank");
        info.put("E-mail", "frank@frank.com");
        info.put("Address", "Beijing, RPC.");
        u1.setUserInfo(info);
        String[] tags = {"Name", "E-mail", "Address"};
        assertEquals("Name: Frank\nE-mail: frank@frank.com\nAddress: Beijing, RPC.\n",u1.showInfo(tags));
        tags[0] = "Nickname";
        assertEquals(Utils.TAGS_INVAILD_WARNING,u1.showInfo(tags));
    }

}
