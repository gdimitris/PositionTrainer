package com.example.dimitris.chesspositiontrainer;

/**
 * Created by dimitris on 3/30/15.
 */
public class Square {

    public String name;
    public Piece piece;

    public Square(String name) {
        this.name = name;
        this.piece = new NullPiece();
    }
}
