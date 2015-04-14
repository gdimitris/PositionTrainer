package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class QueenTests extends TestCase {

    private Queen whiteQueen;
    private Queen blackQueen;

    public void setUp() throws Exception {
        super.setUp();
        whiteQueen = new Queen(Piece.PieceColor.White);
        blackQueen = new Queen(Piece.PieceColor.Black);
    }

    public void testToString() throws Exception {
        assertEquals("♕",whiteQueen.toString());
        assertEquals("♛",blackQueen.toString());
    }
}