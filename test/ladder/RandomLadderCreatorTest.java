package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLadderCreatorTest {

	@Test
	void testGenerateStartPosition() {
		RandomLadderCreator creator = new RandomLadderCreator(LadderSize.create(3, 4));
		Position[] positions = creator.generatePositions();
		for (int i=0; i<positions.length; i++){
			System.out.println(String.format("position: %s", positions[i]));
		}
	}
}
