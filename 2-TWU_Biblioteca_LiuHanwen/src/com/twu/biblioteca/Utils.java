package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by franklau on 2018/7/12.
 */
public class Utils {
    public static final String WELCOME = "Welcome to use Biblioteca!";
    public static final String INVAILD_ERROR = "Error: Select a valid option!";
    public static final String ROW_FORMAT = "%d.%s\n";
    public static final String NO_BOOK_WARNING = "There is no books in the list!\n";
    public static final String CHECK_FAILED_ERROR = "That book is not available.";
    public static final String BOOKS_CHECK_GUIDE = "Book_index/username/password please?";
    public static final String CHECK_OK = "Thank you! Enjoy the book.";
    public static final String BOOKS_RETURN_GUIDE = "Book_name/username/password please?";
    public static final String RETURN_OK = "Thank you for returning the book.";
    public static final String RETURN_FAILED_ERROR = "That is not a valid book to return.";
    public static final String USERNAME_OR_PASSWORD_ERROR = "Username or password error, please try again.";

    public static final String HOME_NAME = "Home";
    public static final String BOOKSMENU_NAME = "List all books.";
    public static final String CHECKMENU_NAME = "Check out a book.";
    public static final String RETURNMENU_NAME = "Return a book.";

    public static final String BACK_HOME_OPTION_NAME = "Back to home.";

    private static List<User> users;

    public static void inputUsers(){
        User u1 = new User("admin", "123456");
        User u2 = new User("guest", "123456");

        users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
    }

    public static User checkUser(String name, String password){
        for(User user:users){
            if(name.compareTo(user.getUsername())==0 && user.auth(password)){return user;}
        }
        return null;
    }
}
