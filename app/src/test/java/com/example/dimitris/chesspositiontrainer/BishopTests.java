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
public class BishopTests {

    private Bishop blackBishop;
    private Bishop whiteBishop;

    @Before
    public void setUp() throws Exception {
        blackBishop = new Bishop(Piece.PieceColor.Black);
        whiteBishop = new Bishop(Piece.PieceColor.White);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("♝",blackBishop.toString());
        assertEquals("♗", whiteBishop.toString());
    }
}