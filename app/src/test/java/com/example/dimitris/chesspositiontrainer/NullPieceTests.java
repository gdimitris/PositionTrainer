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
public class NullPieceTests{

    private Piece nullPiece;

    @Before
    public void setUp() throws Exception {
        nullPiece = Piece.create('?');
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(".",nullPiece.toString());
    }
}