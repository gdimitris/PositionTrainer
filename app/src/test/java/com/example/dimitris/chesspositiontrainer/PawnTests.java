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
public class PawnTests {

    private Pawn whitePawn;
    private Pawn blackPawn;

    @Before
    public void setUp() throws Exception {
        whitePawn = new Pawn(Piece.PieceColor.White);
        blackPawn = new Pawn(Piece.PieceColor.Black);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("♙",whitePawn.toString());
        assertEquals("♟",blackPawn.toString());
    }
}