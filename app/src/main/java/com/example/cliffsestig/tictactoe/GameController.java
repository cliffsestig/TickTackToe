package com.example.cliffsestig.tictactoe;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class GameController {

    Player player1;
    Player player2;

    public GameController(){
        player1 = new Player();
        player1.setPlayerId('X');
        player1.setActive(true);
        player2 = new Player();
        player2.setPlayerId('O');
        player2.setActive(false);
    }





}
