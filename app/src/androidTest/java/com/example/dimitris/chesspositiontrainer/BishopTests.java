package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class BishopTests extends TestCase {

    private Bishop blackBishop;
    private Bishop whiteBishop;

    public void setUp() throws Exception {
        super.setUp();
        blackBishop = new Bishop(Piece.PieceColor.Black);
        whiteBishop = new Bishop(Piece.PieceColor.White);
    }

    public void testToString() throws Exception {
        assertEquals("♝",blackBishop.toString());
        assertEquals("♗",whiteBishop.toString());
    }
}