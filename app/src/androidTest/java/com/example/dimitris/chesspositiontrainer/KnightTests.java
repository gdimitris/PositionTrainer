package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class KnightTests extends TestCase {

    private Knight blackKnight;
    private Knight whiteKnight;

    public void setUp() throws Exception {
        super.setUp();
        blackKnight = new Knight(Piece.PieceColor.Black);
        whiteKnight = new Knight(Piece.PieceColor.White);
    }

    public void testToString() throws Exception {
        assertEquals("♘",whiteKnight.toString());
        assertEquals("♞",blackKnight.toString());
    }
}