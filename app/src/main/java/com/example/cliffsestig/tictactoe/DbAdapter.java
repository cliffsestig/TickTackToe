package com.example.cliffsestig.tictactoe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by larsh on 12-1-2017.
 */

public class DbAdapter extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "ticktactoe.db";
    private static final int DATABASE_VERSION = 1;

    public DbAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getscore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM ticktactoe order by totalscore asc";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        int val = c.getCount();
        return c;
    }


}
