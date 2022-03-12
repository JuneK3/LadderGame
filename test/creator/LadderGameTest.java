package creator;

import core.NaturalNumber;
import ladder.LadderGame;
import ladder.Marker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
	@Test
	void testRunBigLadderWithDI() {
		LadderGame ladderGame =LadderCreatorFactory.randomLadderGame(new NaturalNumber(10), new NaturalNumber(6));
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}

	@Test
	public void testRunWhenRandomLadderWithDI() {
		LadderGame ladderGame =LadderCreatorFactory.randomLadderGame(new NaturalNumber(3), new NaturalNumber(4));
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}

	@Test
	public void testRunWhenManualLadderWithDI() {
		LadderGame ladderGame =LadderCreatorFactory.manualLadderGame(new NaturalNumber(3), new NaturalNumber(4));
		ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladderGame.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladderGame.drawLine(new NaturalNumber(3), new NaturalNumber(3));

		assertEquals(ladderGame.run(new Marker(1)), new Marker(4));
		assertEquals(ladderGame.run(new Marker(2)), new Marker(1));
		assertEquals(ladderGame.run(new Marker(3)), new Marker(2));
		assertEquals(ladderGame.run(new Marker(4)), new Marker(3));
	}
}
