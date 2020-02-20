package com.devcreature.moderndashboard.data;

import com.devcreature.moderndashboard.R;
import com.devcreature.moderndashboard.model.MenuModel;

import java.util.ArrayList;

public class MenuData {
    private static String[] MENU = {
            "Baseball",
            "Basketball",
            "Football",
            "Golf",
            "Rugby",
            "Soccer",
            "MMA",
            "Lainnya"
    };

    private static int[] IMAGE = {
            R.drawable.ic_sports_baseball,
            R.drawable.ic_sports_basketball,
            R.drawable.ic_sports_football,
            R.drawable.ic_sports_golf,
            R.drawable.ic_sports_rugby,
            R.drawable.ic_sports_soccer,
            R.drawable.ic_sports_mma,
            R.drawable.ic_widgets
    };

    private static int[] COLOR = {
            R.drawable.bg_blue,
            R.drawable.bg_blue,
            R.drawable.bg_yellow,
            R.drawable.bg_blue,
            R.drawable.bg_yellow,
            R.drawable.bg_blue,
            R.drawable.bg_red,
            R.drawable.bg_menu
    };

    public static ArrayList<MenuModel> getListData() {
        ArrayList<MenuModel> list = new ArrayList<>();
        for (int position = 0; position < IMAGE.length; position++) {
            MenuModel model = new MenuModel();
            model.setImage(IMAGE[position]);
            model.setName(MENU[position]);
            model.setColor(COLOR[position]);
            list.add(model);
        }
        return list;
    }
}
