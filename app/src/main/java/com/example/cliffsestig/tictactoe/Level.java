package com.example.cliffsestig.tictactoe;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class Level {
    private int timer = 20;
    private int level = 1;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getLevel() {
        return level;
    }

    public int getTimer() {
        return timer;
    }
}
