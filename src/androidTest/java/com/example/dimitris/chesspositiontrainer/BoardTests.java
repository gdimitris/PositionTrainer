package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

/**
 * Created by dimitris on 3/28/15.
 */
public class BoardTests extends TestCase {

    private Board board;
    private Piece piece;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        board = new Board();
        piece = new Piece();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetsCorrectSquares(){
        Square e4square = board.getSquareAt("e4");
        assertEquals("e4",e4square.name);

        Square e8square = board.getSquareAt("e8");
        assertEquals("e8",e8square.name);

        Square d5square = board.getSquareAt("d5");
        assertEquals("d5",d5square);

        Square h1square = board.getSquareAt("h1");
        assertEquals("h1",h1square);

        Square b7square = board.getSquareAt("b7");
        assertEquals("b7",b7square.name);
    }

    public void testGetsPieceAtE4(){
        board.setPieceAtSquare(piece,"e4");
        assertEquals(piece,board.getPieceAt("e4"));
    }

}
