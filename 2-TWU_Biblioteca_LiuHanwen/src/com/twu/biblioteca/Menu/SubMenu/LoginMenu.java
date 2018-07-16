package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.User;
import com.twu.biblioteca.Utils;

/**
 * Created by franklau on 2018/7/16.
 */
public class LoginMenu extends BaseMenu {

    private static LoginMenu me;
    private static User curUser;

    public static User getCurUser() {
        return curUser;
    }

    private LoginMenu(){
        this.name = Utils.LOGINMENU_NAME;
    }

    public static LoginMenu getInstance(){
        if(me==null){
            me = new LoginMenu();
        }
        return me;
    }

    @Override
    public BaseMenu doAction(String input) {
        try{
            String[] inputs = input.split("/");
            if(inputs.length!=2){
                throw new Exception(Utils.INVAILD_ERROR);
            }

            curUser = User.authUserFromAll(inputs[0], inputs[1]);

            if (curUser==null){
                System.out.println(Utils.USERNAME_OR_PASSWORD_ERROR);
                return me;
            }

            return HomeMenu.getInstance();

        }
        catch(Exception e){
            System.out.println(Utils.INVAILD_ERROR);
            return me;
        }
    }

    @Override
    public void show() {

        System.out.println(Utils.LOGIN_GUIDE);
    }
}
