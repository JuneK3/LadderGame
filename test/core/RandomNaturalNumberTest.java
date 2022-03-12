package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNaturalNumberTest {
	@Test
	void testGetPositionOfPerson() {
		RandomNaturalNumber number = new RandomNaturalNumber(4);
		int actual = number.getPositionOfPerson(3);
		assertEquals(1, actual);
	}

	@Test
	void testGetPositionOfHeight() {
		RandomNaturalNumber number = new RandomNaturalNumber(4);
		int actual = number.getPositionOfHeight(3);
		assertEquals(2, actual);
	}

	@Test
	void testIsMultipleOfPerson() {
		RandomNaturalNumber randomNumber = new RandomNaturalNumber(8);
		assertTrue(randomNumber.isMultipleOfPerson(4));
		randomNumber = new RandomNaturalNumber(5);
		assertFalse(randomNumber.isMultipleOfPerson(3));
	}
}
