package com.example.cliffsestig.tictactoe;

import android.util.Log;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class GameBoard {
    private String theBoard[][];

    public GameBoard(){
        theBoard = new String[3][3];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                theBoard[i][j] = "";
            }
        }
    }


    //Determines if there is a winner or not checks each diagonal then loops through each row/column
    public boolean isWinner() {
            // Check Diagonals
            if (theBoard[0][0] == theBoard[1][1] && theBoard[0][0] == theBoard[2][2] && !theBoard[0][0].equals(""))

                return true;

            if (theBoard[2][0] == theBoard[1][1] && theBoard[2][0] == theBoard[0][2] && !theBoard[2][0].equals(""))

                return true;

            for (int i = 0; i < 3; i++) {

                // Check Rows
                if (theBoard[i][0] == theBoard[i][1] && theBoard[i][1] == theBoard[i][2] && !theBoard[i][0].equals(""))

                    return true;

                // Check Columns
                if (theBoard[0][i] == theBoard[1][i] && theBoard[1][i] == theBoard[2][i] && !theBoard[0][i].equals(""))

                    return true;
            }

        return false;
    }

    public void fillBoard(int input, String player) {
        switch (input){
            case 0:
                theBoard[0][0] = player;
                break;
            case 1:
                theBoard[0][1] = player;
                break;
            case 2:
                theBoard[0][2] = player;
                break;
            case 3:
                theBoard[1][0] = player;
                break;
            case 4:
                theBoard[1][1] = player;
                break;
            case 5:
                theBoard[1][2] = player;
                break;
            case 6:
                theBoard[2][0] = player;
                break;
            case 7:
                theBoard[2][1] = player;
                break;
            case 8:
                theBoard[2][2] = player;
                break;
        }
    }
}
