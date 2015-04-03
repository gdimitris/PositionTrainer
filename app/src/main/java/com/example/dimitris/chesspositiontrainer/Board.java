package com.example.dimitris.chesspositiontrainer;

import java.util.StringTokenizer;

import static com.example.dimitris.chesspositiontrainer.Piece.PieceColor;

/**
 * Created by dimitris on 3/28/15.
 */
public class Board {

    private static final String columns = "abcdefgh";
    private static final String rows = "87654321";
    private Square[][] board = new Square[8][8];

    public Board() {
        initializeBoard();
    }

    public Board(String FEN) {
        initializeBoard();
        initializeBoard(FEN);
        printBoard();
    }

    private void initializeBoard(String FEN) {
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
        Square squareToEdit = getSquareAt(square);
        squareToEdit.piece = piece;
    }

    public Piece getPieceAt(String square) {
        return getSquareAt(square).piece;
    }

    public Square getSquareAt(String square) {
        int rowIndex = getIndexOfRow(square.charAt(1));
        int colIndex = getIndexOfColumn(square.charAt(0));

        return board[rowIndex][colIndex];
    }

    private int getIndexOfColumn(char column) {
        return columns.indexOf(column);
    }

    private int getIndexOfRow(char row) {
        return rows.indexOf(row);
    }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col].piece.toString());
            }
            System.out.println();
        }
    }
}
