package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
	@Test
	void testCreatePosition() {
		Position position1 = Position.create(new NaturalNumber(1), new NaturalNumber(3));
		Position position2 = Position.create(1, 3);
		assertEquals(position1, position2);
	}

	@Test
	void testCreateFromArrayIndex() {
		Position arrayPosition = Position.createFromArrayIndex(2, 3);
		Position position = Position.create(3, 4);
		assertEquals(position, arrayPosition);
	}
}
