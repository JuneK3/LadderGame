package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
	@Test
	void testRunBigLadder() {
		LadderGame ladderGame = new LadderGame(new NaturalNumber(10), new NaturalNumber(6));
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}

	@Test
	public void testRunWhenMultiRows() {
		LadderGame ladderGame = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
		Marker result = ladderGame.run(new Marker(2));
		System.out.println(result);
	}
}
