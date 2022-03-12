package creator;

import core.NaturalNumber;
import core.RandomNaturalNumber;
import creator.RandomLadderCreator;
import ladder.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLadderCreatorTest {

	@Test
	void testGenerateStartPosition() {
		ManualLadderCreator manualLadderCreator = new ManualLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		RandomLadderCreator creator = new RandomLadderCreator(manualLadderCreator);
		Position[] positions = creator.generateStartPositions();
		for (int i = 0; i < positions.length; i++) {
			System.out.println(String.format("position: %s", positions[i]));
		}
	}

	@Test
	void testIsExisted() {
		RandomNaturalNumber[] startPositions = {new RandomNaturalNumber(2), new RandomNaturalNumber(3)};
		assertTrue(RandomLadderCreator.isExisted(startPositions, new RandomNaturalNumber(2)));
		assertFalse(RandomLadderCreator.isExisted(startPositions, new RandomNaturalNumber(4)));
	}
}
