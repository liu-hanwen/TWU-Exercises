package com.twu.biblioteca;

/**
 * Created by franklau on 2018/7/13.
 */
public abstract class Checkable {
    private boolean avaliable;
    private User latestUser;

    public Checkable(){
        this.avaliable = true;
    }

    public User getLatestUser() {
        return latestUser;
    }

    public boolean ifAvaliable(){
        return this.avaliable;
    }

    public boolean checkout(User user){
        if(ifAvaliable()){
            this.avaliable = false;
            this.latestUser = user;
            return true;
        }
        return false;
    }

    public boolean return_(User user){
        if(!ifAvaliable() && this.latestUser==user){
            this.avaliable = true;
            return true;
        }
        return false;
    }

    public abstract String show();
}
