package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 4/14/15.
 */
public class NullPieceTests extends TestCase {

    private NullPiece nullPiece;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        nullPiece = new NullPiece();
    }

    public void testToString() throws Exception {
        assertEquals(".",nullPiece.toString());
    }
}