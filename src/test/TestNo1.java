package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bigChess.ChessBoard;
import bigChess.Pawn;
import bigChess.Space;
import bigChess.Piece;
import javafx.scene.layout.GridPane;

public class TestNo1 extends GridPane {

	@Before
	public void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testChessBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpace() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetActiveSpace() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetActiveSpace() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDefineStartPositions() {
		fail("Not yet implemented");
	}

	@Test
	public void testOnSpaceClick() {
		fail("Not yet implemented");
	}

	@Test
	public void testProcessMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testProcessOpponentMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveIsValid() {
		fail("Not yet implemented");
	}

	@Test
	public void testPawnValidityCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testPawnPromotion() {
		//ChessBoard board = new ChessBoard(true);
		Pawn pawn = new Pawn(true);
		//Space space = new Space(true,0,7);
		//space.setPiece(new Pawn(true));
		//assertEquals(true,board.pawnPromotion(space));
	}

}
