package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;
import static ladder.LadderGame.LadderType.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
	@Test
	void testRunBigLadder() {
		LadderGame ladderGame = new LadderGame(new NaturalNumber(10), new NaturalNumber(6), RANDOM);
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}

	@Test
	public void testRunWhenRandomLadder() {
		LadderGame ladderGame = new LadderGame(new NaturalNumber(3), new NaturalNumber(4), RANDOM);
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}

	@Test
	public void testRunWhenManualLadder() {
		LadderGame ladderGame = new LadderGame(new NaturalNumber(3), new NaturalNumber(4), MANUAL);
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladderGame.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladderGame.drawLine(new NaturalNumber(3), new NaturalNumber(3));

		assertEquals(ladderGame.run(new Marker(1)), new Marker(4));
		assertEquals(ladderGame.run(new Marker(2)), new Marker(1));
		assertEquals(ladderGame.run(new Marker(3)), new Marker(2));
		assertEquals(ladderGame.run(new Marker(4)), new Marker(3));
	}
}
