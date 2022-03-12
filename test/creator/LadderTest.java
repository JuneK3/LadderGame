package creator;

import static org.junit.jupiter.api.Assertions.*;
import core.NaturalNumber;
import ladder.LadderGame;
import ladder.Marker;
import org.junit.jupiter.api.Test;


public class LadderTest {

	@Test
	public void testDrawLineWhenRowIsOverLimit() {
		try {
			ManualLadderCreator ladderCreator = new ManualLadderCreator(new NaturalNumber(4), new NaturalNumber(3));
			LadderGame ladderGame = new LadderGame(ladderCreator);
			ladderGame.drawLine(new NaturalNumber(5), new NaturalNumber(2));
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testRunWhenNoLine() {
		ManualLadderCreator ladderCreator = new ManualLadderCreator(new NaturalNumber(1), new NaturalNumber(3));
		LadderGame ladderGame = new LadderGame(ladderCreator);
		Marker target = ladderGame.run(new Marker(1));
		assertEquals(new Marker(1), target);

		target = ladderGame.run(new Marker(2));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenLineLeft() {
		// 1 -1 0
		ManualLadderCreator ladderCreator = new ManualLadderCreator(new NaturalNumber(1), new NaturalNumber(3));
		LadderGame ladderGame = new LadderGame(ladderCreator);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));

		Marker target = ladderGame.run(new Marker(2));
		assertEquals(new Marker(1), target);

		// 0 1 -1
		ladderCreator = new ManualLadderCreator(new NaturalNumber(1), new NaturalNumber(3));
		ladderGame = new LadderGame(ladderCreator);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(2));

		target = ladderGame.run(new Marker(3));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenLineRight() {
		// 0 1 1
		ManualLadderCreator ladderCreator = new ManualLadderCreator(new NaturalNumber(1), new NaturalNumber(3));
		LadderGame ladderGame = new LadderGame(ladderCreator);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(2));

		Marker target = ladderGame.run(new Marker(2));
		assertEquals(new Marker(3), target);

		// 1 1 0
		ladderCreator = new ManualLadderCreator(new NaturalNumber(1), new NaturalNumber(3));
		ladderGame = new LadderGame(ladderCreator);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));

		target = ladderGame.run(new Marker(1));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenMultiRows() {
		// 1 1 0 0
		// 0 1 1 0
		// 0 0 1 1
		ManualLadderCreator ladderCreator = new ManualLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		LadderGame ladderGame = new LadderGame(ladderCreator);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladderGame.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladderGame.drawLine(new NaturalNumber(3), new NaturalNumber(3));

		assertEquals(ladderGame.run(new Marker(1)), new Marker(4));
		assertEquals(ladderGame.run(new Marker(2)), new Marker(1));
		assertEquals(ladderGame.run(new Marker(3)), new Marker(2));
		assertEquals(ladderGame.run(new Marker(4)), new Marker(3));
	}
}
