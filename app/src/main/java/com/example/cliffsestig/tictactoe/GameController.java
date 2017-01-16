package com.example.cliffsestig.tictactoe;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import static com.example.cliffsestig.tictactoe.R.id.txt_time;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class GameController {

    private Player player1;
    private Player player2;

    public GameController(){
        player1 = new Player();
        player1.setPlayerId('X');
        player1.setActive(true);
        player2 = new Player();
        player2.setPlayerId('O');
        player2.setActive(false);
    }

    public String checkTurn(){
        String turn = "";

        if (player1.getActive() == true){
            turn = "player1";
            player1.setActive(false);
            player2.setActive(true);
        } else {
            turn = "player2";
            player1.setActive(true);
            player2.setActive(false);
        }
        return turn;
    }

}
