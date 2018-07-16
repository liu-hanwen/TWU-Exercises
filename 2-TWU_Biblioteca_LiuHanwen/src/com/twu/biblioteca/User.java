package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by franklau on 2018/7/13.
 */
public class User {
    private String username;
    private int pwd;
    private static HashMap<String, User> allUsers = new HashMap<String, User>();
    private HashMap<String, String> info;

    public static User authUserFromAll(String username, String pwd){
        User he = allUsers.get(username);
        if(he==null || !he.auth(pwd)){
            return null;
        }
        return he;
    }

    public static boolean addUser(User user){

        if(allUsers.containsKey(user.getUsername())){ return false; }
        allUsers.put(user.getUsername(), user);
        return true;
    }

    public static void setAllUsers(HashMap<String, User> hm){
        allUsers = hm;
    }

    public static void setAllUsers(){
        allUsers = new HashMap<String, User>();
    }

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

    public void setUserInfo(HashMap<String, String> info){
        this.info = info;
    }

    public String showInfo(){
        if(info==null || info.keySet().size()==0){
            return Utils.INFO_NOT_SET_WARNING;
        }

        String ret = "";
        for(String key:info.keySet()){
            ret+=String.format(Utils.INFO_FORMAT, key, info.get(key));
        }
        return ret;
    }

    public String showInfo(String[] tags){
        if(info==null || info.keySet().size()==0){
            return Utils.INFO_NOT_SET_WARNING;
        }

        String ret = "";
        for(String key:tags){
            if(!info.containsKey(key)){return Utils.TAGS_INVAILD_WARNING;}
            ret+=String.format(Utils.INFO_FORMAT, key, info.get(key));
        }
        return ret;
    }
}
