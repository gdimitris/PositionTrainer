package com.example.dimitris.chesspositiontrainer;

/**
 * Created by dimitris on 4/3/15.
 */
public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        this.color = color;
        this.type = PieceType.Pawn;
    }

    @Override
    public String toString() {
        return (this.color == PieceColor.White) ? Piece.White_Pawn_Unicode : Piece.Black_Pawn_Unicode;
    }
}
