package com.twu.biblioteca.Menu.SubMenu;

import com.twu.biblioteca.Menu.BaseMenu;
import com.twu.biblioteca.Utils;

/**
 * Created by franklau on 2018/7/16.
 */
public class InfoMenu extends BaseMenu{
    private static InfoMenu me;

    private InfoMenu(){
        this.name = Utils.INFOMENU_NAME;
    }

    public static InfoMenu getInstance(){
        if (me==null){
            me = new InfoMenu();
        }
        return me;
    }

    @Override
    public BaseMenu doAction(String input) {
        return HomeMenu.getInstance();
    }

    @Override
    public void show() {
        System.out.println(Utils.INFO_GUIDE);
        String[] tags = {"Name", "E-mail", "Address"};
        System.out.print(LoginMenu.getCurUser().showInfo(tags));
    }
}
