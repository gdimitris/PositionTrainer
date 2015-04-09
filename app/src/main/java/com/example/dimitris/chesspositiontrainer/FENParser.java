package com.example.dimitris.chesspositiontrainer;

import java.util.StringTokenizer;

import static com.example.dimitris.chesspositiontrainer.Piece.*;

public class FENParser {
    private Square[][] board;

    public FENParser(Square[][] board) {
        this.board = board;
    }

    void addPiecesFromFEN(String FEN) {
        StringTokenizer tokenizer = new StringTokenizer(FEN, " ");
        String boardRepresentation = tokenizer.nextToken();
        int currentRow = 0;
        int currentCol = 0;
        for (int current_index = 0; current_index < boardRepresentation.length(); current_index++) {
            char currentChar = boardRepresentation.charAt(current_index);
            if (currentChar == '/') {
                currentRow++;
                currentCol = 0;
                continue;
            } else if (Character.isDigit(currentChar)) {
                currentCol += Character.getNumericValue(currentChar);
                continue;
            }

            PieceColor color = (Character.isUpperCase(currentChar)) ? PieceColor.White : PieceColor.Black;
            currentChar = Character.toLowerCase(currentChar);

            switch (currentChar) {
                case 'r':
                    board[currentRow][currentCol].piece = new Rook(color);
                    break;
                case 'b':
                    board[currentRow][currentCol].piece = new Bishop(color);
                    break;
                case 'n':
                    board[currentRow][currentCol].piece = new Knight(color);
                    break;
                case 'q':
                    board[currentRow][currentCol].piece = new Queen(color);
                    break;
                case 'k':
                    board[currentRow][currentCol].piece = new King(color);
                    break;
                case 'p':
                    board[currentRow][currentCol].piece = new Pawn(color);
                    break;
            }
            currentCol++;
        }
    }
}