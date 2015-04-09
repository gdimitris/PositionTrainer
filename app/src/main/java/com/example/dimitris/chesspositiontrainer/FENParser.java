package com.example.dimitris.chesspositiontrainer;

import java.util.StringTokenizer;

public class FENParser {

    private Square[][] board;
    private int currentRow = 0;
    private int currentCol = 0;
    private String boardRepresentation;

    public FENParser(Square[][] board) {
        this.board = board;
    }

    void addPiecesFromFEN(String FEN) {
        boardRepresentation = new StringTokenizer(FEN, " ").nextToken();
        for (int i = 0; i < boardRepresentation.length(); i++) {
            char currentChar = boardRepresentation.charAt(i);
            if (currentChar == '/') {
                currentRow++;
                currentCol = 0;
            } else if (Character.isDigit(currentChar)) {
                currentCol += Character.getNumericValue(currentChar);
            } else {
                board[currentRow][currentCol].piece = Piece.create(currentChar);
                currentCol++;
            }
        }
    }
}