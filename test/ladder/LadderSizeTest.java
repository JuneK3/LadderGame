package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderSizeTest {
	@Test
	void testGetPositionOfHeight() {
		LadderSize size = LadderSize.create(3, 4);
		NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
		assertEquals(new NaturalNumber(2) ,actual);
	}

	@Test
	void testGetPositionOfPerson() {
		LadderSize size = LadderSize.create(3, 4);
		NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
		assertEquals(new NaturalNumber(1) ,actual);
	}

	@Test
	void testConvertTotalPositionsToPosition() {
		LadderSize size = LadderSize.create(3, 4);
		Position actual = size.getPosition(new NaturalNumber(5));
		assertEquals(Position.create(2, 1) ,actual);
	}
}
