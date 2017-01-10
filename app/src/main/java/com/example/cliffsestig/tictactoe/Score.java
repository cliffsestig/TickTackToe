package com.example.cliffsestig.tictactoe;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class Score {
    private int score = 0;

    public void updateScore(int value){
        score += value;
    }

    public int getScore() {
        return score;
    }

}
