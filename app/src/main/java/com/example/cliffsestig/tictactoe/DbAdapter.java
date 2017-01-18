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
        String query = "SELECT * FROM ticktactoe order by totalscore desc";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        db.close();
        return c;

    }
    public void resettotalcore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM ticktactoe";
         db.execSQL(query);
        db.close();
    }



    public  boolean CheckIsDataAlreadyInDBorNot(String fieldValue) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String Query = "Select * from ticktactoe where player = '" + fieldValue + "'";
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void update_score(String winner, String playerx, String playero){
        if(winner.equals(playerx)) {
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "insert or replace INTO `ticktactoe` (`player`, `totalscore`, `win`) values ( '" + playerx + "',  ifnull((select totalscore from ticktactoe where player = '" + playerx + "'), 0) + 20, ifnull((select win from ticktactoe where player = '" + playerx + "'), 1) + 1)";
            db.execSQL(query);
            String query2 = "insert or replace INTO `ticktactoe` (`player`, `totalscore`, `lose`) values ( '" + playero + "',  ifnull((select totalscore from ticktactoe where player = '" + playero + "'), 0), ifnull((select lose from ticktactoe where player = '" + playero + "'), 1) + 1)";
            db.execSQL(query2);
            db.close();
        }
        else if(winner.equals(playero)){
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "insert or replace INTO `ticktactoe` (`player`, `totalscore`, `win`) values ( '" + playero + "',  ifnull((select totalscore from ticktactoe where player = '" + playero + "'), 0) + 20, ifnull((select win from ticktactoe where player = '" + playero + "'), 1) + 1)";
            db.execSQL(query);
            String query2 = "insert or replace INTO `ticktactoe` (`player`, `totalscore`, `lose`) values ( '" + playerx + "',  ifnull((select totalscore from ticktactoe where player = '" + playerx + "'), 0), ifnull((select lose from ticktactoe where player = '" + playerx + "'), 1) + 1)";
            db.execSQL(query2);
            db.close();
        }
        else{
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "insert or replace INTO `ticktactoe` (`player`, `totalscore`,`draw`) values ( '" + playero + "',  ifnull((select totalscore from ticktactoe where player = '" + playero + "'), 0) + 10, ifnull((select draw from ticktactoe where player = '" + playero + "'), 0) + 1)";
            db.execSQL(query);
            String query2 = "insert or replace INTO `ticktactoe` (`player`, `totalscore`,`draw`) values ( '" + playerx + "',  ifnull((select totalscore from ticktactoe where player = '" + playerx + "'), 0) + 10, ifnull((select draw from ticktactoe where player = '" + playerx + "'), 0) + 1)";
            db.execSQL(query2);
            db.close();
        }
    }
}
