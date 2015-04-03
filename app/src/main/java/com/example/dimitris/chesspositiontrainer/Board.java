package com.example.dimitris.chesspositiontrainer;

/**
 * Created by dimitris on 3/28/15.
 */
public class Board {

    private Square[][] board = new Square[8][8];
    private static final String columns = "abcdefgh";
    private static final String rows = "87654321";

    public Board(){
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (char col = 'a'; col <= 'h'; col++) {
                int row_num = 8 - row;
                String squareName = String.format("%s%d", col, row_num);
                int col_index = columns.indexOf(col);
                board[row][col_index] = new Square(squareName);
            }
        }
    }

    public void setPieceAtSquare(Piece piece, String square) {

    }

    public Piece getPieceAt(String square) {
        return null;
    }

    public Square getSquareAt(String square){
        int rowIndex = getIndexOfRow(square.charAt(1));
        int colIndex = getIndexOfColumn(square.charAt(0));

        return board[rowIndex][colIndex];
    }

    private int getIndexOfColumn(char column){
        return columns.indexOf(column);
    }

    private int getIndexOfRow(char row){
        return rows.indexOf(row);
    }
}
