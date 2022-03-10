package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLadderCreatorTest {

	@Test
	void testGenerateStartPosition() {
		RandomLadderCreator creator = new RandomLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		int[] positions = creator.generatePositions();
		for (int i=0; i<positions.length; i++){
			System.out.println(String.format("position: %d", positions[i]));
		}
	}

	@Test
	void testCountOfLine() {
		int countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(20), 0.3);
		assertEquals(6, countOfLine);
		countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(5), 0.3);
		assertEquals(1, countOfLine);
	}
}
