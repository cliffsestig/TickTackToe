package com.example.cliffsestig.tictactoe;

/**
 * Created by Cliff Sestig on 10-Jan-17.
 */

public class GameBoard {
    //Determines if there is a winner or not checks each diagonal then loops through each row/column
    public boolean isWinner() {
        // Check Diagonals
        if (theBoard[0][0] == theBoard[1][1] && theBoard[0][0] == theBoard[2][2] && theBoard[0][0] != "")

            return true;

        if (theBoard[2][0] == theBoard[1][1] && theBoard[2][0] == theBoard[0][2] && theBoard[2][0] != "")

            return true;

        for (int i = 0; i < 3; i++) {

// Check Rows
            if (theBoard[i][0] == theBoard[i][1] && theBoard[i][1] == theBoard[i][2] && theBoard[i][0] != "")

                return true;

// Check Columns
            if (theBoard[0][i] == theBoard[1][i] && theBoard[1][i] == theBoard[2][i] && theBoard[0][i] != "")

                return true;

        }

        return false;
    }
}
