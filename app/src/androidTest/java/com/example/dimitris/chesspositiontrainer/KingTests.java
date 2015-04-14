package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class KingTests extends TestCase {

    private King whiteKing;
    private King blackKing;

    public void setUp() throws Exception {
        super.setUp();
        whiteKing = new King(Piece.PieceColor.White);
        blackKing = new King(Piece.PieceColor.Black);
    }

    public void testToString() throws Exception {
        assertEquals("♔",whiteKing.toString());
        assertEquals("♚",blackKing.toString());
    }
}