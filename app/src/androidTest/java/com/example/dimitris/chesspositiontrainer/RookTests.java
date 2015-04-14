package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class RookTests extends TestCase {

    private Rook whiteRook;
    private Rook blackRook;

    public void setUp() throws Exception {
        super.setUp();
        whiteRook = new Rook(Piece.PieceColor.White);
        blackRook = new Rook(Piece.PieceColor.Black);
    }

    public void testToString() throws Exception {
        assertEquals("♖",whiteRook.toString());
        assertEquals("♜",blackRook.toString());
    }
}