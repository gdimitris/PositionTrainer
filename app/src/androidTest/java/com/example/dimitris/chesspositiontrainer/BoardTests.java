package com.example.dimitris.chesspositiontrainer;

import junit.framework.TestCase;

import static com.example.dimitris.chesspositiontrainer.Piece.PieceColor;
import static com.example.dimitris.chesspositiontrainer.Piece.PieceType;


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

    public void testGetsCorrectSquares() {
        Square e4square = board.getSquareAt("e4");
        assertEquals("e4", e4square.name);

        Square e8square = board.getSquareAt("e8");
        assertEquals("e8", e8square.name);

        Square d5square = board.getSquareAt("d5");
        assertEquals("d5", d5square.name);

        Square h1square = board.getSquareAt("h1");
        assertEquals("h1", h1square.name);

        Square b7square = board.getSquareAt("b7");
        assertEquals("b7", b7square.name);
    }

    public void testGetsPieceAtE4() {
        board.setPieceAtSquare(piece, "e4");
        assertEquals(piece, board.getPieceAt("e4"));
    }

    public void testGetsPieceAtD8() {
        board.setPieceAtSquare(piece, "d8");
        assertEquals(piece, board.getPieceAt("d8"));
    }

    public void testCanInitializeFromFEN() {
        setUpInitialPositionFromFEN();

        Piece blackRook = board.getPieceAt("h8");
        assertEquals(blackRook.color, PieceColor.Black);
        assertEquals(blackRook.type, PieceType.Rook);

        Piece blackKnight = board.getPieceAt("g8");
        assertEquals(blackKnight.color, PieceColor.Black);
        assertEquals(blackKnight.type, PieceType.Knight);

        Piece blackBishop = board.getPieceAt("f8");
        assertEquals(blackBishop.color, PieceColor.Black);
        assertEquals(blackBishop.type, PieceType.Bishop);

        Piece blackKing = board.getPieceAt("e8");
        assertEquals(blackKing.color, PieceColor.Black);
        assertEquals(blackKing.type, PieceType.King);

        Piece blackQueen = board.getPieceAt("d8");
        assertEquals(blackQueen.color, PieceColor.Black);
        assertEquals(blackQueen.type, PieceType.Queen);

        Piece blackPawn = board.getPieceAt("a7");
        assertEquals(blackPawn.color, PieceColor.Black);
        assertEquals(blackPawn.type, PieceType.Pawn);

        Piece whiteRook = board.getPieceAt("a1");
        assertEquals(whiteRook.color, PieceColor.White);
        assertEquals(whiteRook.type, PieceType.Rook);

        Piece whiteKnight = board.getPieceAt("b1");
        assertEquals(whiteKnight.color, PieceColor.White);
        assertEquals(whiteKnight.type, PieceType.Knight);

        Piece whiteBishop = board.getPieceAt("c1");
        assertEquals(whiteBishop.color, PieceColor.White);
        assertEquals(whiteBishop.type, PieceType.Bishop);

        Piece whiteQueen = board.getPieceAt("d1");
        assertEquals(whiteQueen.color, PieceColor.White);
        assertEquals(whiteQueen.type, PieceType.Queen);

        Piece whiteKing = board.getPieceAt("e1");
        assertEquals(whiteKing.color, PieceColor.White);
        assertEquals(whiteKing.type, PieceType.King);
    }

    public void testBoardCanPerformMoveE2E4(){
        setUpInitialPositionFromFEN();
        Move move = new Move("e2","e4");
        board.performMove(move);

        Piece pieceAtE4 = board.getPieceAt("e4");
        assertEquals(PieceColor.White, pieceAtE4.color);
        assertEquals(PieceType.Pawn, pieceAtE4.type);

        Piece pieceAtE2 = board.getPieceAt("e2");
        assertEquals(PieceColor.None, pieceAtE2.color);
        assertEquals(PieceType.None, pieceAtE2.type);
    }

    public void testBoardCanPerformMoveNf3(){
        setUpInitialPositionFromFEN();
        Move move = new Move("g1","f3");
        board.performMove(move);

        Piece pieceAtF3 = board.getPieceAt("f3");
        assertEquals(PieceColor.White, pieceAtF3.color);
        assertEquals(PieceType.Knight, pieceAtF3.type);

        Piece pieceAtG1 = board.getPieceAt("g1");
        assertEquals(PieceColor.None, pieceAtG1.color);
        assertEquals(PieceType.None, pieceAtG1.type);
    }

    public void testBoardCanPerformCapture(){
        setUpInitialPositionFromFEN();
        Move move1 = new Move("d2","d4");
        Move move2 = new Move("e7","e5");
        Move move3 = new Move("d4","e5");
        board.performMove(move1);
        System.out.println(board.toString());

        board.performMove(move2);
        System.out.println(board.toString());

        board.performMove(move3);
        System.out.println(board.toString());

        Piece pieceAtE5 = board.getPieceAt("e5");
        assertEquals(PieceColor.White, pieceAtE5.color);
        assertEquals(PieceType.Pawn, pieceAtE5.type);


        Piece pieceAtD2 = board.getPieceAt("d2");
        assertEquals(PieceColor.None, pieceAtD2.color);
        assertEquals(PieceType.None, pieceAtD2.type);



        Piece pieceAtD4 = board.getPieceAt("d4");
        assertEquals(PieceColor.None, pieceAtD4.color);
        assertEquals(PieceType.None, pieceAtD4.type);


        Piece pieceAtE7 = board.getPieceAt("e7");
        assertEquals(PieceColor.None, pieceAtE7.color);
        assertEquals(PieceType.None, pieceAtE7.type);

    }

    public void testToString(){
        setUpInitialPositionFromFEN();
        String expected =   "♜♞♝♛♚♝♞♜\n" +
                            "♟♟♟♟♟♟♟♟\n" +
                            "........\n" +
                            "........\n" +
                            "........\n" +
                            "........\n" +
                            "♙♙♙♙♙♙♙♙\n" +
                            "♖♘♗♕♔♗♘♖\n";

        assertEquals(expected,board.toString());
    }


    private void setUpInitialPositionFromFEN() {
        board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }

}
