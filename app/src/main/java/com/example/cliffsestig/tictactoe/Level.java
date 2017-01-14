package com.example.cliffsestig.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.preference.PreferenceManager;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class Level  {

    private String timer;
    private int level = 1;
    private Context con;

    public Level(Context cont) {
        con = cont;
    }



    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public void setTimer(String timer) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(con);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("time",timer);
        editor.apply();
    }
    public String getTimer() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(con);
        String name = preferences.getString("time", "");
        if(!name.equalsIgnoreCase(""))
        {
            timer = name;
        }

        return timer;
    }




}
