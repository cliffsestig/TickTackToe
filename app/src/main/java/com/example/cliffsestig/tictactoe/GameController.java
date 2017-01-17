package com.example.cliffsestig.tictactoe;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class GameController {

    private Player player1;
    private Player player2;
    private GameBoard game;

    public GameController(){
        game = new GameBoard();
    }

    public void createPlayers(String playerX, String playerO){
            player1 = new Player();
            player1.setPlayerId('X');
            player1.setActive(true);
            player1.setPlayerName(playerX);
            player2 = new Player();
            player2.setPlayerId('O');
            player2.setActive(false);
            player2.setPlayerName(playerO);
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

    public boolean checkGameState(int input, String player){
        game.fillBoard(input, player);
        return game.isWinner();
    }

    public String getResult() {
        String result = "";

        if(!game.isWinner()){
            result = "Tie";
        } else if(!player1.getActive()){
            result = player1.getPlayerName();
        } else if(!player2.getActive()){
            result = player2.getPlayerName();
        }

        return result;
    }

    public ArrayList<String> getPlayersName(){
        ArrayList<String> players = new ArrayList<>();

        players.add(player1.getPlayerName());
        players.add(player2.getPlayerName());

        return players;
    }
}
