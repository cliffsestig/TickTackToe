package com.example.cliffsestig.tictactoe;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by larsh on 12-1-2017.
 */

public class scoreAdapter extends CursorAdapter {
    public scoreAdapter(Context context, Cursor c) {
        super(context, c,0);
    }
    private int i = 0;
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.highscorerow,viewGroup, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView player = (TextView) view.findViewById(R.id.txt_player);
        TextView points =(TextView) view.findViewById(R.id.txt_score);
        TextView rank =(TextView) view.findViewById(R.id.txt_ranknr);


        player.setText(cursor.getString(cursor.getColumnIndex("player")));
        points.setText(cursor.getString(cursor.getColumnIndex("totalscore")));
        rank.setText(cursor.getPosition() +1 + ".");


    }
}
