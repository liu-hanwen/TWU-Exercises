package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/13.
 */
public class User {
    private String username;
    private int pwd;

    public User(String username, String pwd){
        this.username = username;
        this.pwd = pwd.hashCode();
    }

    public String getUsername() {
        return username;
    }

    public void resetPwd(String old_pwd, String new_pwd) throws Exception{

        if(old_pwd.hashCode()==this.pwd){
            this.pwd = new_pwd.hashCode();
        }
        throw new Exception("The old password is not correct.");
    }

    public boolean auth(String pwd){
        return pwd.hashCode()==this.pwd;
    }
}
