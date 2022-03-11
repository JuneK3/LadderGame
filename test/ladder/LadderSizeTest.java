package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderSizeTest {

	private LadderSize size;

	@BeforeEach
	public void setUp() {
		size = LadderSize.create(3, 4);
	}

	@Test
	void testGetPositionOfHeight() {
		NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
		assertEquals(new NaturalNumber(2), actual);
	}

	@Test
	void testGetPositionOfPerson() {
		NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
		assertEquals(new NaturalNumber(1), actual);
	}

	@Test
	void testConvertTotalPositionsToPosition() {
		Position actual = size.getPosition(new NaturalNumber(5));
		assertEquals(Position.create(2, 1), actual);
	}

	@Test
	void testIsMultipleOfPerson() {
		assertTrue(size.isMultipleOfPerson(new NaturalNumber(8)));
		assertFalse(size.isMultipleOfPerson(new NaturalNumber(9)));
	}
}
