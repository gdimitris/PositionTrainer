package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class PawnTests extends TestCase {

    private Pawn whitePawn;
    private Pawn blackPawn;

    public void setUp() throws Exception {
        super.setUp();
        whitePawn = new Pawn(Piece.PieceColor.White);
        blackPawn = new Pawn(Piece.PieceColor.Black);
    }

    public void testToString() throws Exception {
        assertEquals("♙",whitePawn.toString());
        assertEquals("♟",blackPawn.toString());
    }
}