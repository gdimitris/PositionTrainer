package com.example.dimitris.chesspositiontrainer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dimitris on 4/14/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class QueenTests {

    private Queen whiteQueen;
    private Queen blackQueen;

    @Before
    public void setUp() throws Exception {
        whiteQueen = new Queen(Piece.PieceColor.White);
        blackQueen = new Queen(Piece.PieceColor.Black);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("♕",whiteQueen.toString());
        assertEquals("♛",blackQueen.toString());
    }
}