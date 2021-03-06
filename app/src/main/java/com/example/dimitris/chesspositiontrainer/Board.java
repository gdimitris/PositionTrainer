package com.example.dimitris.chesspositiontrainer;

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
        FENParser parser = new FENParser(board);
        parser.addPiecesFromFEN(FEN);
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

    @Override
    public String toString() {
        String toReturn="";
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               toReturn+=board[row][col].piece.toString();
            }
            toReturn+="\n";
        }

        return toReturn;
    }

    public void performMove(Move move) {
        Square source = getSquareAt(move.sourceSquare);
        Square destination = getSquareAt(move.destinationSquare);

        destination.piece = source.piece;
        source.piece = new NullPiece();
    }
}
