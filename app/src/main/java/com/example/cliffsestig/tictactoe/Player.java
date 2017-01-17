package com.example.cliffsestig.tictactoe;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class Player {
    private String playerName;
    private char playerId;
    private boolean active;

    Score score = new Score();

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerId(char playerId) {
        this.playerId = playerId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPlayerName() { return playerName; }

    public char getPlayerId() {
        return playerId;
    }

    public boolean getActive() { return active; }
}
